package com.elastic.www.dto.acknowledgedResourceResponse;

import lombok.Data;

@Data
public class Response{
	private boolean shards_acknowledged;
	private boolean acknowledged;
	private String index;
}
