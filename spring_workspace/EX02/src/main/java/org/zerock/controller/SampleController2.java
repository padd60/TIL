package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@RequestMapping("/sample")
@Log4j
@Controller
public class SampleController2 {
	@GetMapping("/all")
	public void doAll() {
		
	}
	
	@GetMapping("/member")
	public void doMember() {
		
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		
	}
}
