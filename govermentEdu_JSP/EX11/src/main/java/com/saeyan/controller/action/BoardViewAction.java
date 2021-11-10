package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;
import com.saeyan.dto.ReplyVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String url = "/board/boardView.jsp";
		
		//글번호를 받음.글목록에서 글제목을 클릭했을 때.
		String num=null;
		if(request.getParameter("num")!=null){
			num=request.getParameter("num");
			//쿠키 생성
			Cookie c2 = new Cookie(num, "") ;
			response.addCookie(c2);
		}		
		
		//댓글을 등록한 후 상세보기로 넘어갈 때
		if(request.getAttribute("num")!=null){
			num=(String) request.getAttribute("num");
		};
		
		//부모글번호 지정
		int pNum=Integer.parseInt(num);
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		System.out.println("글번호"+num);
		
		
		// 쿠키값 가져오기
	    Cookie[] cookies = request.getCookies() ;
	    Boolean flag = null;
	    
	         
        for(Cookie c : cookies){
             
            // 저장된 쿠키 이름을 가져온다
            String cName = c.getName();
                         
            if(cName.equals(num)) {
            	flag = false;
            }else {
            	flag = true;
            }
        }
		
        if(flag == true) {
        	// 조회수 증가
        	bDao.updateReadCount(num);
        }
		
		//글상세정보
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		
		//댓글목록
		List<ReplyVO> replyList = bDao.selectAllReply(pNum);
		request.setAttribute("replyList", replyList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
