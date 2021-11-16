package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {
	//글목록
	public List<BoardVO> getList();
	//글등록
	public void insert(BoardVO board);
	//글등록
	public void insertSelectKey(BoardVO board);
	//글 상세보기
	public BoardVO read(Long bno);
	//글 삭제
	public int delete(Long bno);
	//글 수정
	public int update(BoardVO board);
}
