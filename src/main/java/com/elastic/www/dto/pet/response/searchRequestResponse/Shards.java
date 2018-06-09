package com.elastic.www.dto.pet.response.searchRequestResponse;

import lombok.Data;

@Data
public class Shards {
    private int total;
    private int failed;
    private int successful;
    private int skipped;
}
