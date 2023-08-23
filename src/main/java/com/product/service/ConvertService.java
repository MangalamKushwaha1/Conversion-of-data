package com.product.service;

public interface ConvertService {
	String convertToCamelCase(String data);
	String sortingEachWordByExclusion(String input, int numToPreserve);
	String removeDuplicateWords(String input,int allowedDuplicateWords);
	String dataSwapping(String input,String swapby,String swapon);




}
