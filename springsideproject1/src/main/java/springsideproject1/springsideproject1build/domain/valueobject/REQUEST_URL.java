package springsideproject1.springsideproject1build.domain.valueobject;

public abstract class REQUEST_URL {
    /**
     * User
     */
    public static final String MEMBERSHIP_URL = "/membership";
    public static final String FIND_ID_URL = "/login/find/id";
    public static final String COMPANY_SUB_URL = "/company";
    public static final String COMPANY_SEARCH_URL = "/company/search/";

    /**
     * Manager
     */

    // Article - Company
    public static final String ADD_SINGLE_COMPANY_ARTICLE_URL = "/manager/article/company/add/single";
    public static final String ADD_COMPANY_ARTICLE_WITH_STRING_URL = "/manager/article/company/add/string";
    public static final String SELECT_COMPANY_ARTICLE_URL = "/manager/article/company/select";
    public static final String UPDATE_COMPANY_ARTICLE_URL = "/manager/article/company/update";
    public static final String REMOVE_COMPANY_ARTICLE_URL = "/manager/article/company/remove";

    // Company
    public static final String ADD_SINGLE_COMPANY_URL = "/manager/company/add/single";
    public static final String SELECT_COMPANY_URL = "/manager/company/select";
    public static final String UPDATE_COMPANY_URL = "/manager/company/update";
    public static final String REMOVE_COMPANY_URL = "/manager/company/remove";

    // Member
    public static final String SELECT_MEMBER_URL = "/manager/member/select";

    /**
     * Common
     */

    // Prefix
    public static final String URL_REDIRECT_PREFIX = "redirect:";

    // Suffix
    public static final String URL_FINISH_SUFFIX = "/finish";
}