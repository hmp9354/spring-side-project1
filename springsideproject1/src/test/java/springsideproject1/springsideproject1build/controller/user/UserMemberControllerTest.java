package springsideproject1.springsideproject1build.controller.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import springsideproject1.springsideproject1build.utility.test.MemberTestUtility;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static springsideproject1.springsideproject1build.config.constant.REQUEST_URL_CONFIG.MEMBERSHIP_URL;
import static springsideproject1.springsideproject1build.config.constant.REQUEST_URL_CONFIG.URL_FINISH_SUFFIX;
import static springsideproject1.springsideproject1build.config.constant.VIEW_NAME_CONFIG.*;
import static springsideproject1.springsideproject1build.utility.ConstantUtils.MEMBER;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserMemberControllerTest implements MemberTestUtility {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("회원가입 페이지 접속")
    @Test
    public void accessMembershipPage() throws Exception {
        mockMvc.perform(get(MEMBERSHIP_URL))
                .andExpectAll(status().isOk(),
                        view().name(MEMBERSHIP_VIEW + VIEW_PROCESS_SUFFIX),
                        model().attributeExists(MEMBER));
    }

    @DisplayName("회원가입 완료 페이지 접속")
    @Test
    public void accessMembershipSucceedPage() throws Exception {
        mockMvc.perform(processPostWithMember(MEMBERSHIP_URL, createTestMember()))
                .andExpectAll(status().isSeeOther(),
                        redirectedUrl(MEMBERSHIP_URL + URL_FINISH_SUFFIX));

        mockMvc.perform(get(MEMBERSHIP_URL + URL_FINISH_SUFFIX))
                .andExpectAll(status().isOk(),
                        view().name(MEMBERSHIP_VIEW + VIEW_FINISH_SUFFIX));
    }
}