package com.elastic.www.dto.pet;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Pet {
    @Builder.Default
    private String name = new Faker().cat().name();
    @Builder.Default
    private String tag = new Faker().cat().registry();
    @Builder.Default
    private String category = new Faker().cat().breed();
    @Builder.Default
    private String status = new Faker().color().name();
}
