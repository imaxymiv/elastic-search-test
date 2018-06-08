package com.elastic.www.responseFormatSuite;

import com.elastic.www.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.elastic.www.client.impl.inidicesCatalogClient.IndicesClient.getIndicesClient;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class ResponseFormatTests extends BaseTest {

    @Test
    public void testResponseFormat() throws IOException {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("format", "yaml");

        Response response = getIndicesClient().getIndicesCatalog(queryParams).getResponse();
        String file = getIndicesClient().getConvertedFromYamlToJsonFile("src/test/resources/entity.yaml");

        response.then().assertThat().body(matchesJsonSchema(file).using(getIndicesClient().getJsonSchemaFactory()));
    }

    @Test
    public void testJsonResponseFormat() {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("format", "json");
        Response response = getIndicesClient().getIndicesCatalog(queryParams).getResponse();

        response.then().assertThat().body(matchesJsonSchema(new File("src/test/resources/entity.json"))
                .using(getIndicesClient().getJsonSchemaFactory()));
    }
}
