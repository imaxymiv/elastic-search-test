package com.elastic.www.dto.pet.response.searchRequestResponse;

import lombok.Data;

import java.util.List;

@Data
public class Hits {
    private List<HitsItem> hits;
    private int total;
    private double max_score;
}