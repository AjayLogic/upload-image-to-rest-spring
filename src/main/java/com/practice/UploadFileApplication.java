package com.practice;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@SpringBootApplication
public class UploadFileApplication {

	private String uplaodDir="/home/mukesh/Documents/workspace-sts-3.9.2.RELEASE/upload-file/src/main/java/uploadedFile";
	public static void main(String[] args) {
		SpringApplication.run(UploadFileApplication.class, args);
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile uploadFile) throws IOException {
		
		saveUploadedFiles(uploadFile);
		return "hello";
	}
	
	public void saveUploadedFiles(MultipartFile uploadFile) throws IOException {
		
		byte []bytes=uploadFile.getBytes();
		Path path=Paths.get(uplaodDir+uploadFile.getOriginalFilename());
		Files.write(path, bytes);
		
		
	}
}
