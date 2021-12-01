package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
//	@Scheduled(cron="0 * * * * *")
//	public void checkFiles() throws Exception{
//		log.warn("자동실행되는 메세지........");
//		log.warn("============================================");
//	}
	
	
	@Setter(onMethod_ = {@Autowired})
	private BoardAttachMapper attachMapper;
	
	private String getFolderYesterDay() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator);
	}
	
	@Scheduled(cron = "0 0 2 * * ?")
	public void checkFiles() throws Exception {
		log.warn("File Check Task run...................");
		log.warn(new Date());
		
		// db의 파일리스트
		List<BoardAttachVO> fileList = attachMapper.getOldFiles();
		
		// 실제 저장 파일 중 db의 파일리스트에 있는 경우
		List<Path> fileListPaths = fileList.stream()
				.map(vo -> Paths.get("/Users/kimjunghwan/Desktop/FileUpload_temp/", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName()))
				.collect(Collectors.toList());
		
		// 이미지 파일의 썸네일 버전
		fileList.stream().filter(vo -> vo.isFileType() == true)
			.map(vo -> Paths.get("/Users/kimjunghwan/Desktop/FileUpload_temp/", vo.getUploadPath(), vo.getUuid() + "s_" + vo.getFileName()))
			.forEach(p -> fileListPaths.add(p));
		
		log.warn("=========================================");
		
		fileListPaths.forEach(p -> log.warn(p));
		
		// 어제 날짜의 파일 폴더
		File targetDir = Paths.get("/Users/kimjunghwan/Desktop/FileUpload_temp/", getFolderYesterDay()).toFile();
		
		File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);
		
		log.warn("-------------------------------------------");
		
		for(File file : removeFiles) {
			
			log.warn(file.getAbsoluteFile());
			
			file.delete();
			
		}
	}
}
