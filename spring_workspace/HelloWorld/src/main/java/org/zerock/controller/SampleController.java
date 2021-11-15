package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("basic........");
	}
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get ......");
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		
		return "list"; //list.jsp로 이동 , 주소랑 jsp파일명이 다를 때 사용
	}
	@GetMapping("/ex02")
	public String ex02(String name, int age) {
		// RequestParam() 사용 안해도 파라미터값 가동으로 수집해 가져옴
		log.info("name: " + name);
		log.info("age: " + age);
		
		return "ex02";
	}
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
		// RequestParam() 생략이 불가한 데이터타입도 있음
		log.info("ids: " + ids);
		
		return "ex02List";
	}
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto: " + dto);
		log.info("page: " + page);
		
		return "/sample/ex04";
	}
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05........");
	}
	@GetMapping("/test")
	public String test() {
		return "/sample/view";
	}
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06........");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw) {
		return "/sample/login_result";
	}
}
