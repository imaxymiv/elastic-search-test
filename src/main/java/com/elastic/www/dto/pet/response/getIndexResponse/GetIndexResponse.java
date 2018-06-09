package com.elastic.www.dto.pet.response.getIndexResponse;

import lombok.Data;

@Data
public class GetIndexResponse {
    private boolean found;
    private String _index;
    private String _type;
    private Source _source;
    private String _id;
    private int _version;
}
