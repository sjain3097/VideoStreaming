package com.sjain.videostreaming.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjain.videostreaming.fileManagement.MyResourceHttpRequestHandler;

@Controller
@RequestMapping("/video")
public class VideoController {
	@Autowired
	private MyResourceHttpRequestHandler handler;
	private final static File MP4_FILE = new File("src/main/resources/2. Folder Structure and Github setup.mp4");
	@GetMapping("/byterange")
	public void byteRange(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		request.setAttribute(MyResourceHttpRequestHandler.ATTR_FILE, MP4_FILE );
		handler.handleRequest(request, response);
	}
	@GetMapping("/index")
	public String something(){
		return "index";
	}
}
