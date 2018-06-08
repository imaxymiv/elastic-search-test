package com.elastic.www.config;

import java.util.HashMap;
import java.util.Map;

import static org.aeonbits.owner.ConfigFactory.create;
import static org.aeonbits.owner.ConfigFactory.setProperty;

public class TestConfig {

    private static String getTestEnvType() {
        return System.getProperty("env", "dev");
    }

    public static String getBaseUrl() {
        setProperty("env", getTestEnvType());
        Env testEnv = create(Env.class);
        return testEnv.baseUrl();
    }

    public static String getUserLogin() {
        Env testUser = create(Env.class);
        return testUser.login();
    }

    public static String getUserName() {
        Env testUser = create(Env.class);
        return testUser.name();
    }

    public static String getUserPassword() {
        Env testUser = create(Env.class);
        return testUser.password();
    }

    public static String getDBBuilderUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.dbBuilderUrl();
    }

    public static String getFormBuilderUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.formBuilderUrl();
    }

    public static String getGridBuilderUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.gridBuilderUrl();
    }

    public static String getAgentUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.agentUrl();
    }

    public static String getAgentCustomersUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.agentCustomersUrl();
    }

    public static String getAgentCasesUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.agentCasesUrl();
    }

    public static String getAdminUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.adminUrl();
    }

    public static String getCalendarUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.calendarUrl();
    }

    public static Email getAccountManagerMail() {
        Map<String, String> users = new HashMap<>();
        users.put("user", "account.manager");
        return create(Email.class, users);
    }

    public static String getSalesQuotation() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.salesQuotationUrl();
    }

    public static String getSalesQuoteUserName() {
        Env salesQuoteUser = create(Env.class);
        return salesQuoteUser.salesQuoteUserName();
    }

    public static String getSalesQuotePassword() {
        Env salesQuoteUser = create(Env.class);
        return salesQuoteUser.salesQuotePassword();
    }

    public static String getLogOnKey() {
        Env salesQuoteUser = create(Env.class);
        return salesQuoteUser.logOnKey();
    }

    public static String getQuoteLoginPage() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.salesQuotationUrl() + testUrl.quoteLoginPage();
    }

    public static Email getNextivaTest5Mail() {
        Map<String, String> users = new HashMap<>();
        users.put("user", "nextivatest5");
        return create(Email.class, users);
    }

    public static String getSurveysUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.surveysUrl();
    }

    public static String getRulesEngineUrl() {
        Url testUrl = create(Url.class);
        return getBaseUrl() + testUrl.rulesEngineUrl();
    }

    public static String getBaseUrlWithDomain(String domain) {
        return getBaseUrl().replaceFirst(getTestEnvType(), domain);
    }

    public static String getAgentWithDomain(String domain) {
        Url testUrl = create(Url.class);
        return getBaseUrlWithDomain(domain) + testUrl.agentUrl();
    }

    public static Mailousaur getMailosaurCredentials() {
        return create(Mailousaur.class);
    }
}
