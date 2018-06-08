package com.elastic.www.client.impl.petIndex;

import com.elastic.www.client.Configuration;
import com.elastic.www.client.ResponseWrapper;
import com.elastic.www.client.RestClient;
import com.elastic.www.dto.acknowledgedResourceResponse.Response;
import com.elastic.www.dto.mappings.petIndexMapping.PetIndex;
import com.github.javafaker.Faker;

public class PetIndexClient extends RestClient {

    public final static String MAPPING_PATH = new Faker().internet().domainWord();

    private static PetIndexClient petIndexClient = new PetIndexClient();

    @Override
    protected Configuration defaultConfiguration() {
        return new Configuration("http://localhost:9200", "application/json", "");
    }

    public static PetIndexClient getPetIndexClient() {
        return petIndexClient;
    }

    public ResponseWrapper<Response> mapPetDoc(PetIndex petIndexPayload) {
        return put(MAPPING_PATH, petIndexPayload, Response.class);
    }

    public ResponseWrapper<PetIndex> removePetDocMapping() {
        return delete(MAPPING_PATH, PetIndex.class);
    }
}
