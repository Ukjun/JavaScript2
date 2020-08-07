package com.koreait.board.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;
import com.koreait.board.vo.BoardVO;

/**
 * Servlet implementation class BoardWriteSer
 */
@WebServlet("/boardWrite")
public class BoardWriteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardRegmod.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String title = request.getParameter("title");
	    String ctnt = request.getParameter("ctnt");
	    String i_student = request.getParameter("i_student");
	    BoardVO para = new BoardVO();
	    para.setTitle(title); 	
	    para.setCtnt(ctnt);
	    para.setI_student(i_student);
	    BoardDAO.insertList(para);
		//request.setAttribute("data",BoardDAO.insertList(para));
//		String jsp = "/WEB-INF/view/boardRegmod.jsp";
//		request.getRequestDispatcher(jsp).forward(request, response);
		response.sendRedirect("/BoardListSer");
		
		
	}

}