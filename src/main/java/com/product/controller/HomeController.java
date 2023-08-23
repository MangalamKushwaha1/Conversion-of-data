package com.product.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;



@RestController
@RequestMapping("/api/file-handler")
public class HomeController {

	@Autowired
	ResourceLoader resourceLoader;
//	@GetMapping("/get-file")
//	public String inputFile() throws IOException{
//		 // read a file
//		Resource resource= resourceLoader.getResource("classpath:key/Convert.txt");
//		
//		 // get inputStream object
//		InputStream inputStream=resource.getInputStream();	
////		
////		   // convert inputStream into a byte array
////		byte[] dataBytes=FileCopyUtils.copyToByteArray(inputStream);
////		
////		// convert the byte array into a String
////		String data=new String(dataBytes,StandardCharsets.UTF_8);
//		
//		File file=resource.getFile();
//		System.out.println(file);
//		return "file";
//	}
//	
	
//	@PostMapping("/upload")
//	public String uploadFile(@RequestParam("file") MultipartFile file) {
////		String fileName=file.getOriginalFilename();
////		file.transferTo("C:\\Users\\mangalamkushwaha\\Desktop\\New folder"+fileName));
//		try {
//			FileWriter fwr=new FileWriter("C:\\Users\\mangalamkushwaha\\Desktop\\New folder\\Convert");
//			fwr.write("Hello Mangalam");
//			fwr.close();
//			System.out.println("You have written something in file");
//			} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//		return "convert";
//	}


//	@PostMapping(value="/upload/file")
//	public ResponseEntity<String>  uploadingFile( MultipartFile file) {
//		String files=file.getOriginalFilename();
//		System.out.println("Inside");
//		return ResponseEntity.ok("success");
//	}
//		
//	ClassLoader loader=getClass().getClassLoader();
//	File file=new File(loader.getResource("Conert.txt").getFile());
//	JsonNode mySchema=JsonLoader.fromFile(file);
	
	
	
//	
//	@GetMapping("/read")
//	public ResponseEntity<?> getResourceInfo() throws IOException{
//	Resource res = resourceLoader.getResource("classpath:Convert.txt"); 
//	String output = ""; 
//	File file = res.getFile();
//	output += "Filename: " + file.getName() + " \n Executable: " + file.canExecute() +
//			"\n Readable: \" + file.canRead()";
//	String content = new String(Files.readAllBytes(file.toPath()));
//	System.out.println(content); 
//	return new ResponseEntity<>(content,HttpStatus.OK);
// }
	
	@GetMapping("/file/read")
	public String fileRead() throws IOException {
		
		File f=new ClassPathResource("Convert.txt").getFile();
		FileInputStream fis=null;
		
		try {
			fis=new FileInputStream(f);
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getPath());
			System.out.println(fis.available());
			
			int content;
			while((content=fis.read()) != -1) {
				System.out.println((char) content);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) {
					fis.close();
				}
			}catch (Exception e2) {
					e2.printStackTrace();
				}
		}
		return "done";
	}
}
