package com.elastic.www.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:mail.properties"})
public interface Mailousaur extends Config {

    @Key("mailosaur.apikey")
    String apiKey();

    @Key("server.id")
    String serverId();

    @Key("email.pattern")
    String emailPattern();

}
