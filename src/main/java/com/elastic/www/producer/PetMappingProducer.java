package com.elastic.www.producer;

import com.elastic.www.dto.mappings.petIndexMapping.*;

public class PetMappingProducer {

    public static PetIndex produceMapping() {
        PetIndex petIndex = new PetIndex();
        petIndex
                .setSettings(new Settings()
                        .setNumber_of_shards(1))
                .setMappings(new Mappings()
                        .setPet(new Pet()
                                .setProperties(new Properties()
                                        .setCategory(new Category().setType("text"))
                                        .setName(new Name().setType("text"))
                                        .setStatus(new Status().setType("text"))
                                        .setTag(new Tag().setType("text")))));
        return petIndex;
    }
}
