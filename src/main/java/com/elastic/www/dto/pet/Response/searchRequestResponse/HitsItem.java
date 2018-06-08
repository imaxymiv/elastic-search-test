package com.elastic.www.dto.pet.Response.searchRequestResponse;

import lombok.Data;

@Data
public class HitsItem {
    private String _index;
    private String _type;
    private Source _source;
    private String _id;
    private double _score;
}
