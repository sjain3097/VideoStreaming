package com.sjain.videostreaming.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjain.videostreaming.fileManagement.FileManagement;

@RestController
public class MyController {
	@Autowired
	private FileManagement fileManagement;
	
	@GetMapping("/tutorialVideoName")
	public ResponseEntity<?> getTutorialVideoName() throws IOException{
		Map<File, Map<File, List<File>>> tutorials = fileManagement.getVideoNameList();
		return new ResponseEntity<Map<File,Map<File,List<File>>>>(tutorials, HttpStatus.OK);
	}
//	@GetMapping("/")
//	public ResponseEntity<?> something(){
//		return new ResponseEntity<String>("kfsdfjsdkl", HttpStatus.OK);
//	}
	
}
