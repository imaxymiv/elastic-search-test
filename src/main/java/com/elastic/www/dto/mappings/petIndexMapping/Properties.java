package com.elastic.www.dto.mappings.petIndexMapping;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Properties{
	private Name name;
	private Tag tag;
	private Category category;
	private Status status;
}
