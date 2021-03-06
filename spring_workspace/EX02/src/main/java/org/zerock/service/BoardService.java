package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	// 글 등록
	public void register(BoardVO board);
	// 글 전체 보기 
	public BoardVO get(Long bno);
	// 글수정 
	public boolean modify(BoardVO board);
	// 글삭제 
	public boolean remove(Long bno);
	// 글목록 
//	public List<BoardVO> getList();
	
	// 범위지정 글목록
	public List<BoardVO> getList(Criteria cri);
	
	// 전체 쪽수
	public int getTotal(Criteria cri);
	
	public List<BoardAttachVO> getAttachList(Long bno);
}
