package com.product.dto;

import java.util.Map;

import lombok.Data;

@Data
public class APIResponse {

	private boolean status;
	private String message;

	private Map<String, String> response;

}
