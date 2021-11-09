package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.ReplyVO;

public class ReplyDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		String num=request.getParameter("pNum");
		
		//부모글번호 지정
		int pNum=Integer.parseInt(num);
		
		String no = request.getParameter("no");
		String pass = request.getParameter("password");
		
		BoardDAO bDao = BoardDAO.getInstance();
		ReplyVO rVo = bDao.selectOneReplyByNum(no);
		
		if(rVo.getPassword().equals(pass)) {
			
			bDao.deleteReply(no);
			
			url = "BoardServlet?command=board_view&num="+ pNum +"&check=true";
		} else {
			url = "BoardServlet?command=board_view&num="+ pNum +"&check=false";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
