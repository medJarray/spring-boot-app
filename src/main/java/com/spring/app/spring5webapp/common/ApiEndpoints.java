package com.spring.app.spring5webapp.common;

public final class ApiEndpoints {

    public static final String EMPLOYERS = "/employers";
    public static final String EMPLOYERS_SEARCH_BY_NAME = "/employers/search";

    public static final String TICKETS = "/tickets";

    public static final String VERSION = "/version";

    /**
     * The caller references the constants using <tt>ApiEndpoints.EMPLOYERS_SEARCH_BY_NAME</tt>,
     * and so on. Thus, the caller should be prevented from constructing objects of
     * this class, by declaring this private constructor.
     */
    private ApiEndpoints() {
        //this prevents even the native class from
        //calling this constructor as well :
        throw new AssertionError();
    }

}
