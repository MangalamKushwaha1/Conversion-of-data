package com.product.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.product.dto.APIResponse;
import com.product.service.ConvertService;

@RestController
@RequestMapping("/api/v1/content")
public class MainController {

	@Autowired
	private ConvertService convertService;


	@PostMapping("/data")
	public ResponseEntity<APIResponse> getData(@RequestParam("file") MultipartFile file,
			@RequestParam("exclusive") int exclusive, @RequestParam("swapby") String swapby,
			@RequestParam("swapon") String swapon) throws IOException {
		APIResponse apiResponse = new APIResponse();
		
		// file uploading
		if(file.isEmpty()) {
			apiResponse.setMessage("File is empty");
			return new ResponseEntity<>(apiResponse,HttpStatus.NO_CONTENT);
		}

		String data=new String(file.getBytes());
		
		Map<String, String> map = new HashMap<>();
		map.put("Original Data", data);
		map.put("upperCase Data", data.toUpperCase());
		map.put("lowerCase Data", data.toLowerCase());
		map.put("camelCase Data", convertService.convertToCamelCase(data));
		map.put("Sorting", convertService.sortingEachWordByExclusion(data, exclusive));
		map.put("Swapping", convertService.dataSwapping(data, swapby, swapon));

		apiResponse.setStatus(true);
		apiResponse.setMessage("Succesfully done");
		apiResponse.setResponse(map);
		return new ResponseEntity<>(apiResponse, HttpStatus.OK);
	}

	/*
	@PostMapping("/convert")
	public ResponseEntity<APIResponse> convertFile(@RequestParam("file") MultipartFile file) {

		APIResponse apiresponse = new APIResponse();
		Map<String, String> result = new HashMap<>();

		// check file is empty or not
		if (file.isEmpty()) {
			apiresponse.setMessage("File is empty");
			return new ResponseEntity<>(apiresponse, HttpStatus.NO_CONTENT);
//		result.put("error", "File is empty");
//		return new ResponseEntity<>(result,HttpStatus.NO_CONTENT);
		}

		// check file extension
		String originalFileName = file.getOriginalFilename();
		if (!originalFileName.endsWith(".txt")) {
			apiresponse.setMessage("Only .txt files are allowwed");
			return new ResponseEntity<>(apiresponse, HttpStatus.BAD_REQUEST);
		}

		try {
			String data = new String(file.getBytes());
			result.put("originnal Data", data);
			result.put("upperCase Data", data.toUpperCase());
			result.put("lowerCase Data", data.toLowerCase());
			result.put("camelCase Data", convertService.convertToCamelCase(data));

			apiresponse.setStatus(true);
			apiresponse.setMessage("Conversion successful");
			apiresponse.setResponse(result);
			return new ResponseEntity<>(apiresponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			apiresponse.setStatus(false);
			apiresponse.setMessage("Not saved");
			apiresponse.setResponse(result);
			return new ResponseEntity<>(apiresponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Set String as input through Request Param
	@PostMapping("/sort")
	public String sortingEachWordByExclusionOfString(@RequestParam("input") String input,
			@RequestParam("numToPreserve") int numToPreserve) {
		return convertService.sortingEachWordByExclusion(input, numToPreserve);

	}

	// Sorting Content of uploading file from Device
	@PostMapping("/sorts")
	public ResponseEntity<String> sortingEachWordByExclusionOfString(@RequestParam("file") MultipartFile file,
			@RequestParam int exclusive) throws IOException {
		if (file.isEmpty()) {
			return new ResponseEntity<>("Successfully done", HttpStatus.NO_CONTENT);
		} else {
			byte[] bytes = file.getBytes();
			String content = new String(bytes);
			String result = convertService.sortingEachWordByExclusion(content, exclusive);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
	}
	
	// specify the maximum number of allowed duplicate words in a given string.
	@PostMapping("/remove/duplicate")
	public String duplicateWords(@RequestParam("input") String input, @RequestParam("allowedDuplicateWords") int allowedDuplicateWords) {
		
		return convertService.removeDuplicateWords(input, allowedDuplicateWords);
	}
	
	@PostMapping("/swap")
		public String swap(@RequestParam("input")String input,@RequestParam("swapby") String swapby, @RequestParam("swapon") String swapon) {
			return convertService.dataSwapping(input,swapby,swapon);
		}
		
	*/
	
	
	
	
	}

