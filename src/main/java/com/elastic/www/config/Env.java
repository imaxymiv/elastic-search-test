package com.elastic.www.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface Env extends Config {

    @Key("baseurl.path")
    String baseUrl();

    @Key("agentzero.login")
    String login();

    @Key("agentzero.name")
    String name();

    @Key("agentzero.password")
    String password();

    @Key("salesQuote.user.name")
    String salesQuoteUserName();

    @Key("salesQuote.password")
    String salesQuotePassword();

    @Key("logOn.key")
    String logOnKey();
}
