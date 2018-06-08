package com.elastic.www.compareDocsSuite;

import com.elastic.www.BaseTest;
import com.elastic.www.dto.pet.Pet;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static com.elastic.www.client.impl.pet.PetClient.getPetClient;
public class CompareDocsTests extends BaseTest {

    @Test
    public void testEqualityOfDocs() {
        Faker faker = new Faker();
        String id = faker.number().digits(3);

        Pet petObject = Pet.builder().build();
        getPetClient()
                .putPet(petObject, id)
                .expectingStatusCode(201);

        Assertions.assertThat(getPetClient().getCreatedDoc(id)
                .readEntity().get_source()).isEqualToComparingFieldByField(petObject);
    }
}
