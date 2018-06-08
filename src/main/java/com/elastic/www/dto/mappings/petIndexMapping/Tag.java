package com.elastic.www.dto.mappings.petIndexMapping;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class Tag{
	private String type;
}
