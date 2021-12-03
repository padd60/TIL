package com.mycompany.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.service.SampleService;


@Controller
@RequestMapping("/test")
public class SampleController {
	
	@Resource(name="SampleService")
	private SampleService sampleService;
	
	@RequestMapping("/test.do")
	public @ResponseBody String testDB() throws Exception{
		System.out.println("test.do");
		return sampleService.testDB();
		
	}

}
