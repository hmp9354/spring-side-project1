package springsideproject1.springsideproject1build.utility.test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import springsideproject1.springsideproject1build.domain.company.Company;
import springsideproject1.springsideproject1build.domain.company.Country;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static springsideproject1.springsideproject1build.utility.ConstantUtility.CODE;

public interface CompanyTestUtility extends ObjectTestUtility {

    // DB table name
    String companyTable = "testcompanies";

    /**
     * Create
     */
    default Company createSamsungElectronics() {
        return Company.builder().code("005930").country(Country.SOUTH_KOREA).scale("big").name("삼성전자")
                .category1st("electronics").category2nd("semiconductor").build();
    }

    default Company createSKHynix() {
        return Company.builder().code("000660").country(Country.SOUTH_KOREA).scale("big").name("SK하이닉스")
                .category1st("electronics").category2nd("semiconductor").build();
    }

    /**
     * Request
     */
    default MockHttpServletRequestBuilder processPostWithCompany(String url, Company company) {
        return post(url).contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param(CODE, company.getCode())
                .param("country", company.getCountry().name())
                .param("scale", company.getScale())
                .param("name", company.getName())
                .param("category1st", company.getCategory1st())
                .param("category2nd", company.getCategory2nd());
    }
}
