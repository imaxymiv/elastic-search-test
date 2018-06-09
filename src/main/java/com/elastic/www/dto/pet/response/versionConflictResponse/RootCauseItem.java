package com.elastic.www.dto.pet.response.versionConflictResponse;

import lombok.Data;

@Data
public class RootCauseItem {
    private String reason;
    private String index_uuid;
    private String index;
    private String shard;
    private String type;
}
