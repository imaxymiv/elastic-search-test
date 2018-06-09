package com.elastic.www.dto.pet.response.putRequestResponse;

import lombok.Data;

@Data
public class Shards{
	private int total;
	private int failed;
	private int successful;
}
