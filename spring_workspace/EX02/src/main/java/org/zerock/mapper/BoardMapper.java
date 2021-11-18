package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	//글목록
	public List<BoardVO> getList();
	
	//글목록 페이징처리해 불러오기
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	//글등록
	public void insert(BoardVO board);
	//글등록
	public void insertSelectKey(BoardVO board);
	//글 상세보기
	public BoardVO read(Long bno);
	//글 삭제 (반환 int값은 영향을 받은 행의 수)
	public int delete(Long bno);
	//글 수정 (반환 int값은 영향을 받은 행의 수)
	public int update(BoardVO board);
}
