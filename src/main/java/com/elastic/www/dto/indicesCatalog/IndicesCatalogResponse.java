package com.elastic.www.dto.indicesCatalog;

import lombok.Data;

@Data
public class IndicesCatalogResponse {
    private String priStoreSize;
    private String docsDeleted;
    private String pri;
    private String health;
    private String index;
    private String rep;
    private String uuid;
    private String storeSize;
    private String status;
    private String docsCount;
}
