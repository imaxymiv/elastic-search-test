package com.elastic.www.client.impl.inidicesCatalogClient;

import com.elastic.www.client.Configuration;
import com.elastic.www.client.ResponseWrapper;
import com.elastic.www.client.RestClient;
import com.elastic.www.dto.indicesCatalog.IndicesCatalogResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.*;
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

    public JsonNode getConvertedFromYamlToJsonFile(String pathname) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readTree(pathname);
    }

}
