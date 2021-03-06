package com.saeyan.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int pageno;
		if(request.getParameter("pageno")!=null){
			pageno=Integer.parseInt(request.getParameter("pageno"));
			System.out.println(pageno);
		}else{
			pageno=1;
		}
		
		String url = "/board/boardList.jsp";
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		List<BoardVO> boardList = bDao.selectAllBoards(pageno);
		int recordCount = bDao.selectCountBoard();
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
