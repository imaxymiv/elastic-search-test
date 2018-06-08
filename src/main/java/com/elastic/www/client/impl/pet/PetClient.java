package com.elastic.www.client.impl.pet;

import com.elastic.www.client.Configuration;
import com.elastic.www.client.ResponseWrapper;
import com.elastic.www.client.RestClient;
import com.elastic.www.dto.pet.Pet;
import com.elastic.www.dto.pet.Response.getIndexResponse.GetIndexResponse;
import com.elastic.www.dto.pet.Response.putRequestResponse.PetResponse;
import com.elastic.www.dto.pet.Response.searchRequestResponse.SearchQueryResponse;
import com.github.javafaker.Faker;

import java.util.Map;

public class PetClient extends RestClient {
    private static String indexPathName = new Faker().internet().domainWord();
    private final static String PUT_PATH = indexPathName + "/pet/%s";
    private final static String SEARCH_PATH = indexPathName + "/_search";

    private static PetClient petClient = new PetClient();

    public static PetClient getPetClient() {
        return petClient;
    }

    @Override
    protected Configuration defaultConfiguration() {
        return new Configuration("http://localhost:9200", "application/json", "");
    }

    public ResponseWrapper<PetResponse> putPet(Pet petPayload, String id) {
        return put(String.format(PUT_PATH, id), petPayload, PetResponse.class);
    }

    public ResponseWrapper<PetResponse> deletePet(String id) {
        return delete(String.format(PUT_PATH, id), PetResponse.class);
    }


    public ResponseWrapper<SearchQueryResponse> searchDoc(Map<String, String> queryParams) throws InterruptedException {
        ResponseWrapper<SearchQueryResponse> response = get(SEARCH_PATH, queryParams, SearchQueryResponse.class);
        for (int i = 0; i < 15; i++) {
            if (response.readEntity().getHits().getHits().size() != 0) {
                return response;
            } else {
                Thread.sleep(30);
                response = get(SEARCH_PATH, queryParams, SearchQueryResponse.class);
            }
        }
        return response;
    }

    public ResponseWrapper<GetIndexResponse> getCreatedDoc(String id) {
        return get(String.format(PUT_PATH, id), GetIndexResponse.class);
    }

    public ResponseWrapper<GetIndexResponse> getCreatedDocWithVersion(String id, Map<String, String> queryParams) {
        return get(String.format(PUT_PATH, id), queryParams, GetIndexResponse.class);
    }

}
