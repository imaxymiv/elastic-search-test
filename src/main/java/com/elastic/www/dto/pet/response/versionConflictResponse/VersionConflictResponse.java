package com.elastic.www.dto.pet.response.versionConflictResponse;

import lombok.Data;

@Data
public class VersionConflictResponse {
    private Error error;
    private int status;
}
