package com.elastic.www.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mail.properties"})
public interface Email extends Config {

    String user();

    @Key("${user}.login")
    String login();

    @Key("${user}.password")
    String password();

}
