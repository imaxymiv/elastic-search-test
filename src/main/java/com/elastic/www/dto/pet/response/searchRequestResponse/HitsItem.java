package com.elastic.www.dto.pet.response.searchRequestResponse;

import lombok.Data;

@Data
public class HitsItem {
    private String _index;
    private String _type;
    private Source _source;
    private String _id;
    private double _score;
}
