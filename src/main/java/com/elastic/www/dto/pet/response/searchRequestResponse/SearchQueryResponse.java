package com.elastic.www.dto.pet.response.searchRequestResponse;

import lombok.Data;

@Data
public class SearchQueryResponse {
    private Shards _shards;
    private Hits hits;
    private int took;
    private boolean timed_out;
}
