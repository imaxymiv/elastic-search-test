package com.elastic.www.client.impl.inidicesCatalogClient;

import com.elastic.www.client.Configuration;
import com.elastic.www.client.ResponseWrapper;
import com.elastic.www.client.RestClient;
import com.elastic.www.dto.indicesCatalog.IndicesCatalogResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.SchemaVersion;
import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.json.JSONObject;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class IndicesClient extends RestClient {
    private final static String INDICES_CATALOG_PATH = "/_cat/indices";
    private static IndicesClient indicesClient = new IndicesClient();

    public static IndicesClient getIndicesClient() {
        return indicesClient;
    }

    @Override
    protected Configuration defaultConfiguration() {
        return new Configuration("http://localhost:9200", "application/yaml", "");
    }

    public ResponseWrapper<IndicesCatalogResponse> getIndicesCatalog(Map<String, String> queryParams) {
        return get(INDICES_CATALOG_PATH, queryParams, IndicesCatalogResponse.class);
    }

    public String getConvertedFromYamlToJsonFile(String pathname) throws IOException {
        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(new FileReader(pathname));
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toString();

    }

    public JsonSchemaFactory getJsonSchemaFactory() {
        return JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
                .freeze();
    }

}
