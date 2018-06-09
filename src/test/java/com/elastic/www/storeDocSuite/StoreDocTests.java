package com.elastic.www.storeDocSuite;

import com.elastic.www.BaseTest;
import com.elastic.www.dto.pet.Pet;
import com.elastic.www.dto.pet.response.getIndexResponse.GetIndexResponse;
import com.elastic.www.dto.pet.response.putRequestResponse.PetResponse;
import com.elastic.www.dto.pet.response.versionConflictResponse.VersionConflictResponse;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.elastic.www.client.impl.pet.PetClient.getPetClient;
public class StoreDocTests extends BaseTest {
    private Faker faker = new Faker();

    @Test
    public void testStoreDoc() {
        String id = faker.number().digits(3);

        Pet petObject = Pet.builder().build();
        PetResponse petResponse = getPetClient()
                .putPet(petObject, id)
                .expectingStatusCode(201)
                .readEntity();
        Assert.assertTrue(petResponse.get_id().equalsIgnoreCase(id));
        Assert.assertEquals(1, petResponse.get_version());
        Assert.assertTrue(petResponse.getResult().equalsIgnoreCase("created"));
    }

    @Test
    public void testVersioning() {
        Pet petObject = Pet.builder().build();
        String id = faker.number().digits(3);

        getPetClient()
                .putPet(petObject, id)
                .expectingStatusCode(201);
        getPetClient()
                .deletePet(id)
                .expectingStatusCode(200);
        PetResponse petResponse = getPetClient()
                .putPet(petObject, id)
                .expectingStatusCode(201)
                .readEntity();

        Map<String, String> versionQueryParam = new HashMap<>();
        versionQueryParam.put("version", String.valueOf(petResponse.get_version()));

        GetIndexResponse petResponseWithVersion = getPetClient()
                .getCreatedDocWithVersion(id, versionQueryParam)
                .expectingStatusCode(200)
                .readEntity();

        Assert.assertEquals(3, petResponseWithVersion.get_version());
    }

    @Test
    public void testVersioningConflict() {
        Pet petObject = Pet.builder().build();
        String id = faker.number().digits(3);

        getPetClient()
                .putPet(petObject, id)
                .expectingStatusCode(201);
        PetResponse petResponse = getPetClient().
                putPet(petObject, id)
                .expectingStatusCode(200)
                .readEntity();

        Map<String, String> versionQueryParam = new HashMap<>();
        versionQueryParam.put("version", String.valueOf(petResponse.get_version() - 1));

        VersionConflictResponse petResponseWithVersionConflict = getPetClient()
                .getCreatedDocWithVersionConflict(id, versionQueryParam)
                .expectingStatusCode(409)
                .readEntity();

        Assert.assertTrue(petResponseWithVersionConflict.getError().getRoot_cause().get(0).getType()
                .equalsIgnoreCase("version_conflict_engine_exception"));
    }
}
