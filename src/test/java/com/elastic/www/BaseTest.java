package com.elastic.www;

import com.elastic.www.dto.mappings.petIndexMapping.PetIndex;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.elastic.www.client.impl.petIndex.PetIndexClient.getPetIndexClient;
import static com.elastic.www.producer.PetMappingProducer.produceMapping;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        PetIndex givenMapping = produceMapping();
        getPetIndexClient()
                .mapPetDoc(givenMapping);
    }

    @AfterMethod(alwaysRun = true)
    public void removeMapping() {
        getPetIndexClient()
                .removePetDocMapping()
                .expectingStatusCode(200);
    }
}
