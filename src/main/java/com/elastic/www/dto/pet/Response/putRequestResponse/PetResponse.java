package com.elastic.www.dto.pet.Response.putRequestResponse;

import lombok.Data;

@Data
public class PetResponse{
	private String result;
	private Shards _shards;
	private int _seq_no;
	private String _index;
	private String _type;
	private String _id;
	private int _version;
	private int _primary_term;
}
