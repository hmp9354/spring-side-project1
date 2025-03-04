package springsideproject1.springsideproject1build.controller.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import springsideproject1.springsideproject1build.domain.entity.company.Company;
import springsideproject1.springsideproject1build.domain.entity.company.Country;
import springsideproject1.springsideproject1build.domain.entity.company.Scale;
import springsideproject1.springsideproject1build.domain.service.CompanyService;
import springsideproject1.springsideproject1build.util.test.CompanyTestUtils;

import javax.sql.DataSource;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static springsideproject1.springsideproject1build.domain.valueobject.CLASS.COMPANY;
import static springsideproject1.springsideproject1build.domain.valueobject.DATABASE.COMPANY_TABLE;
import static springsideproject1.springsideproject1build.domain.valueobject.LAYOUT.*;
import static springsideproject1.springsideproject1build.domain.valueobject.REQUEST_URL.*;
import static springsideproject1.springsideproject1build.domain.valueobject.VIEW_NAME.*;
import static springsideproject1.springsideproject1build.domain.valueobject.WORD.NAME;
import static springsideproject1.springsideproject1build.domain.valueobject.WORD.VALUE;
import static springsideproject1.springsideproject1build.util.MainUtils.encodeWithUTF8;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ManagerCompanyControllerTest implements CompanyTestUtils {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    CompanyService companyService;

    private final JdbcTemplate jdbcTemplateTest;

    @Autowired
    public ManagerCompanyControllerTest(DataSource dataSource) {
        jdbcTemplateTest = new JdbcTemplate(dataSource);
    }

    @BeforeEach
    public void beforeEach() {
        resetTable(jdbcTemplateTest, COMPANY_TABLE);
    }

    @DisplayName("기업 추가 페이지 접속")
    @Test
    public void accessCompanyAdd() throws Exception {
        mockMvc.perform(get(ADD_SINGLE_COMPANY_URL))
                .andExpectAll(status().isOk(),
                        view().name(addSingleCompanyProcessPage),
                        model().attribute(LAYOUT_PATH, ADD_PROCESS_PATH),
                        model().attributeExists(COMPANY),
                        model().attribute("countries", Country.values()),
                        model().attribute("scales", Scale.values()));
    }

    @DisplayName("기업 추가 완료 페이지 접속")
    @Test
    public void accessCompanyAddFinish() throws Exception {
        // given & when
        Company company = samsungElectronics;

        // then
        mockMvc.perform(postWithCompany(ADD_SINGLE_COMPANY_URL, company))
                .andExpectAll(status().isFound(),
                        redirectedUrlPattern(ADD_SINGLE_COMPANY_URL + URL_FINISH_SUFFIX + ALL_QUERY_STRING),
                        model().attribute(NAME, encodeWithUTF8(company.getName())));

        mockMvc.perform(getWithSingleParam(ADD_SINGLE_COMPANY_URL + URL_FINISH_SUFFIX,
                        NAME, encodeWithUTF8(company.getName())))
                .andExpectAll(status().isOk(),
                        view().name(ADD_COMPANY_VIEW + VIEW_SINGLE_FINISH_SUFFIX),
                        model().attribute(LAYOUT_PATH, ADD_FINISH_PATH),
                        model().attribute(VALUE, company.getName()));

        assertThat(companyService.findCompanyByName(company.getName()).orElseThrow())
                .usingRecursiveComparison()
                .isEqualTo(company);
    }

    @DisplayName("기업 변경 페이지 접속")
    @Test
    public void accessCompanyModify() throws Exception {
        mockMvc.perform(get(UPDATE_COMPANY_URL))
                .andExpectAll(status().isOk(),
                        view().name(UPDATE_COMPANY_VIEW + VIEW_BEFORE_PROCESS_SUFFIX),
                        model().attribute(LAYOUT_PATH, UPDATE_PROCESS_PATH));
    }

    @DisplayName("기업 변경 페이지 내 코드 검색")
    @Test
    public void searchCodeCompanyModify() throws Exception {
        // given
        Company company = samsungElectronics;

        // when
        companyService.registerCompany(company);

        // then
        assertThat(requireNonNull(mockMvc.perform(postWithSingleParam(UPDATE_COMPANY_URL, "codeOrName", company.getCode()))
                .andExpectAll(status().isOk(),
                        view().name(modifyCompanyProcessPage),
                        model().attribute(LAYOUT_PATH, UPDATE_PROCESS_PATH),
                        model().attribute("updateUrl", modifyCompanyFinishUrl))
                .andReturn().getModelAndView()).getModelMap().get(COMPANY))
                .usingRecursiveComparison()
                .isEqualTo(company.toDto());
    }

    @DisplayName("기업 변경 페이지 내 이름 검색")
    @Test
    public void searchNameCompanyModify() throws Exception {
        // given
        Company company = samsungElectronics;

        // when
        companyService.registerCompany(company);

        // then
        assertThat(requireNonNull(mockMvc.perform(postWithSingleParam(UPDATE_COMPANY_URL, "codeOrName", company.getName()))
                .andExpectAll(status().isOk(),
                        view().name(modifyCompanyProcessPage),
                        model().attribute(LAYOUT_PATH, UPDATE_PROCESS_PATH),
                        model().attribute("updateUrl", modifyCompanyFinishUrl),
                        model().attribute("countries", Country.values()),
                        model().attribute("scales", Scale.values()))
                .andReturn().getModelAndView()).getModelMap().get(COMPANY))
                .usingRecursiveComparison()
                .isEqualTo(company.toDto());
    }

    @DisplayName("기업 변경 완료 페이지 접속")
    @Test
    public void accessCompanyModifyFinish() throws Exception {
        // given
        Company company = samsungElectronics;
        String commonName = samsungElectronics.getName();
        Company modifiedCompany = Company.builder().company(company)
                .name(commonName).code(company.getCode()).build();

        // when
        companyService.registerCompany(company);

        // then
        mockMvc.perform(postWithCompany(modifyCompanyFinishUrl, modifiedCompany))
                .andExpectAll(status().isFound(),
                        redirectedUrlPattern(modifyCompanyFinishUrl + ALL_QUERY_STRING),
                        model().attribute(NAME, encodeWithUTF8(commonName)));

        mockMvc.perform(getWithSingleParam(modifyCompanyFinishUrl, NAME, encodeWithUTF8(company.getName())))
                .andExpectAll(status().isOk(),
                        view().name(UPDATE_COMPANY_VIEW + VIEW_FINISH_SUFFIX),
                        model().attribute(LAYOUT_PATH, UPDATE_FINISH_PATH),
                        model().attribute(VALUE, commonName));

        assertThat(companyService.findCompanyByName(commonName).orElseThrow())
                .usingRecursiveComparison()
                .isEqualTo(modifiedCompany);
    }

    @DisplayName("기업들 조회 페이지 접속")
    @Test
    public void accessCompaniesInquiry() throws Exception {
        // given & when
        companyService.registerCompanies(skHynix, samsungElectronics);

        // then
        assertThat(requireNonNull(mockMvc.perform(get(SELECT_COMPANY_URL))
                .andExpectAll(status().isOk(),
                        view().name(MANAGER_SELECT_VIEW + "companiesPage"))
                .andReturn().getModelAndView()).getModelMap().get("companies"))
                .usingRecursiveComparison()
                .isEqualTo(List.of(skHynix, samsungElectronics));
    }

    @DisplayName("기업 없애기 페이지 접속")
    @Test
    public void accessCompanyRid() throws Exception {
        mockMvc.perform(get(REMOVE_COMPANY_URL))
                .andExpectAll(status().isOk(),
                        view().name(REMOVE_COMPANY_VIEW + VIEW_PROCESS_SUFFIX),
                        model().attribute(LAYOUT_PATH, REMOVE_PROCESS_PATH));
    }

    @DisplayName("기업 코드로 기업 없애기 완료 페이지 접속")
    @Test
    public void codeAccessCompanyRidFinish() throws Exception {
        // given
        Company company = samsungElectronics;
        String name = company.getName();

        // when
        companyService.registerCompany(company);

        // then
        mockMvc.perform(postWithSingleParam(REMOVE_COMPANY_URL, "codeOrName", company.getCode()))
                .andExpectAll(status().isFound(),
                        redirectedUrlPattern(REMOVE_COMPANY_URL + URL_FINISH_SUFFIX + ALL_QUERY_STRING),
                        model().attribute(NAME, encodeWithUTF8(name)));

        mockMvc.perform(getWithSingleParam(REMOVE_COMPANY_URL + URL_FINISH_SUFFIX, NAME, encodeWithUTF8(name)))
                .andExpectAll(status().isOk(),
                        view().name(REMOVE_COMPANY_VIEW + VIEW_FINISH_SUFFIX),
                        model().attribute(LAYOUT_PATH, REMOVE_FINISH_PATH),
                        model().attribute(VALUE, name));

        assertThat(companyService.findCompanies()).isEmpty();
    }

    @DisplayName("기업명으로 기업 없애기 완료 페이지 접속")
    @Test
    public void nameAccessCompanyRidFinish() throws Exception {
        // given
        Company company = samsungElectronics;
        String name = company.getName();

        // when
        companyService.registerCompany(company);

        // then
        mockMvc.perform(postWithSingleParam(REMOVE_COMPANY_URL, "codeOrName", name))
                .andExpectAll(status().isFound(),
                        redirectedUrlPattern(REMOVE_COMPANY_URL + URL_FINISH_SUFFIX + ALL_QUERY_STRING),
                        model().attribute(NAME, encodeWithUTF8(name)));

        mockMvc.perform(getWithSingleParam(REMOVE_COMPANY_URL + URL_FINISH_SUFFIX, NAME, encodeWithUTF8(name)))
                .andExpectAll(status().isOk(),
                        view().name(REMOVE_COMPANY_VIEW + VIEW_FINISH_SUFFIX),
                        model().attribute(LAYOUT_PATH, REMOVE_FINISH_PATH),
                        model().attribute(VALUE, name));

        assertThat(companyService.findCompanies()).isEmpty();
    }
}