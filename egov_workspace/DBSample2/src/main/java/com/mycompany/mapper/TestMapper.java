package com.mycompany.mapper;

import java.util.List;

import com.mycompany.vo.SampleVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("TestMapper")
public interface TestMapper {
	List<SampleVO> testDB() throws Exception;

}
