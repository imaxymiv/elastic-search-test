package com.elastic.www.mappingTestSuite;

import com.elastic.www.BaseTest;
import com.elastic.www.dto.acknowledgedResourceResponse.Response;
import com.elastic.www.dto.mappings.petIndexMapping.PetIndex;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.elastic.www.client.impl.petIndex.PetIndexClient.MAPPING_PATH;
import static com.elastic.www.client.impl.petIndex.PetIndexClient.getPetIndexClient;
import static com.elastic.www.producer.PetMappingProducer.produceMapping;

public class MappingTests {

    @Test
    public void verifyPetIndexMapping() {
        PetIndex givenMapping = produceMapping();
        Response actualMapping = getPetIndexClient()
                .mapPetDoc(givenMapping)
                .expectingStatusCode(200)
                .expectingContentType("application/json; charset=UTF-8")
                .readEntity();
        Assert.assertTrue(actualMapping.isAcknowledged());
        Assert.assertTrue(actualMapping.isShards_acknowledged());
        Assert.assertTrue(actualMapping.getIndex().equalsIgnoreCase(MAPPING_PATH));
    }

    @AfterMethod
    public void removeMapping() {
        getPetIndexClient()
                .removePetDocMapping()
                .expectingStatusCode(200);
    }
}
