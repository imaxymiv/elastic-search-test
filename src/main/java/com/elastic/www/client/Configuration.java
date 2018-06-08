package com.elastic.www.client;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Configuration {
    private String servicePath;
    private String contentType;
    private String auth;
}
