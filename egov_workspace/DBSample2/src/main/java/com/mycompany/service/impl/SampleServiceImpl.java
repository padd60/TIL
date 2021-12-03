package com.mycompany.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycompany.mapper.TestMapper;
import com.mycompany.service.SampleService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("SampleService")
public class SampleServiceImpl extends EgovAbstractServiceImpl implements SampleService{

	@Resource(name="TestMapper")
	private TestMapper testMapper;
	
	@Override
	public String testDB() throws Exception {
		
		return testMapper.testDB().get(0).getTest();
	}

	
}
