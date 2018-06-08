package com.elastic.www.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:url.properties"})
public interface Url extends Config {

    @Key("dbbuilder.path")
    String dbBuilderUrl();

    @Key("agent.path")
    String agentUrl();

    @Key("formbuilder.path")
    String formBuilderUrl();

    @Key("gridbuilder.path")
    String gridBuilderUrl();

    @Key("agent.customers.path")
    String agentCustomersUrl();

    @Key("admin.path")
    String adminUrl();

    @Key("salesQuotation.path")
    String salesQuotationUrl();

    @Key("quote.login.path")
    String quoteLoginPage();

    @Key("calendar.path")
    String calendarUrl();

    @Key("agent.cases.path")
    String agentCasesUrl();

    @Key("survey.path")
    String surveysUrl();

    @Key("rulesengine.path")
    String rulesEngineUrl();
}
