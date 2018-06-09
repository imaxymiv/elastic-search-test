package com.elastic.www.dto.pet.response.versionConflictResponse;

import lombok.Data;

import java.util.List;

@Data
public class Error {
    private String reason;
    private String index_uuid;
    private String index;
    private String shard;
    private String type;
    private List<RootCauseItem> root_cause;
}