package com.elastic.www.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Slf4j
public abstract class RestClient {
    protected Configuration configuration = defaultConfiguration();
    private RequestSpecification requestSpecification;

    protected abstract Configuration defaultConfiguration();

    public RestClient() {
        init();
    }

    private void init(){
        RestAssured.baseURI = configuration.getServicePath();
        requestSpecification = new RequestSpecBuilder()
                .setContentType(configuration.getContentType())
                .log(LogDetail.ALL)
                .build();
    }

    private void logResponse(Response response) {
        response.then().log().all();
    }

    public <F> ResponseWrapper<F> get(String path, Class<F> responseClass){
        Response response = given().spec(requestSpecification).get(path);
        logResponse(response);
        return new ResponseWrapper<>(response, responseClass);
    }

    public <F> ResponseWrapper<F> get(String path, Map<String, String> queryParams, Class<F> responseClass){
        Response response = given().spec(requestSpecification).queryParams(queryParams).get(path);
        logResponse(response);
        return new ResponseWrapper<>(response, responseClass);
    }

    public <T, F> ResponseWrapper<F> post(String path, T payload, Class<F> responseClass){
        Response response = given().spec(requestSpecification).body(payload).post(path);
        logResponse(response);
        return new ResponseWrapper<>(response, responseClass);
    }

    public <T, F> ResponseWrapper<F> patch(String path, T payload, Class<F> responseClass){
        Response response = given().body(payload).patch(path);
        logResponse(response);
        return new ResponseWrapper<>(response, responseClass);
    }

    public <T, F> ResponseWrapper<F> put(String path, T payload, Class<F> responseClass){
        Response response = given().spec(requestSpecification).body(payload).put(path);
        logResponse(response);
        return new ResponseWrapper<>(response, responseClass);
    }

    public <F> ResponseWrapper<F> delete(String path, Class<F> responseClass){
        Response response = given().spec(requestSpecification).delete(path);
        logResponse(response);
        return new ResponseWrapper<>(response, responseClass);
    }
}