package com.elastic.www.searchDocSuite;

import com.elastic.www.BaseTest;
import com.elastic.www.dto.pet.Pet;
import com.elastic.www.dto.pet.response.searchRequestResponse.SearchQueryResponse;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.elastic.www.client.impl.pet.PetClient.getPetClient;

public class SearchDocTests extends BaseTest {

    @Test
    public void testSearchDoc() throws InterruptedException {
        Faker faker = new Faker();
        String id = faker.number().digits(3);

        Pet petObject = Pet.builder().build();
        getPetClient()
                .putPet(petObject, id)
                .expectingStatusCode(201);

        Map<String, String> params = new HashMap<>();
        params.put("q", "name=" + petObject.getName().toLowerCase());

        SearchQueryResponse searchQueryResponse = getPetClient().searchDoc(params)
                .expectingStatusCode(200)
                .readEntity();

        Assert.assertTrue(searchQueryResponse.getHits().getHits().stream()
                .anyMatch(petName -> petName.get_source().getName().equalsIgnoreCase(petObject.getName())));
    }
}
