/*
 * Copyright (c) 2017 Nextiva, Inc. to Present.
 * All rights reserved.
 */

package com.elastic.www.client;

import io.restassured.response.Response;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResponseWrapper<T> {
    private final Response response;
    private final Class<T> responseClass;

    ResponseWrapper(Response response, Class<T> responseClass) {
        this.response = response;
        this.responseClass = responseClass;
    }

    public Response getResponse() {
        return response;
    }

    public T readEntity() {
        return response.getBody().as(responseClass);
    }

    public List<T> readEntities() {
        return response.getBody().jsonPath().getList("content", responseClass);
    }

    public ResponseWrapper<T> expectingStatusCode(int statusCode) {
        assertThat("Response code differs", response.getStatusCode(), is(statusCode));
        return this;
    }

    public ResponseWrapper<T> expectingContentType(String contentType) {
        assertThat("Content _type differs", response.getContentType(), is(contentType));
        return this;
    }
}
