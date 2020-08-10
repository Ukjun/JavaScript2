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
	BoardVO para = new BoardVO();
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
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board, 0);
		System.out.println(i_board);
//		BoardDAO.insertList(para);
		if(i_board==0) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardRegmod.jsp");
			rd.forward(request, response);
		}else
		{
			System.out.println(i_board);
			if(i_board==0) {
				response.sendRedirect("/boardList");
				return;
			}else {
				BoardVO para = new BoardVO();
				para.setI_board(i_board);
				request.setAttribute("data", BoardDAO.detailBoardList(para));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardRegmod.jsp?i_board="+strI_board);
				rd.forward(request, response);
			}	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(i_board);
		String strI_board = request.getParameter("i_board");
		int i_board = Utils.parseStringToInt(strI_board, 0);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String i_student = request.getParameter("i_student");
		
		para.setI_board(i_board);
		para.setTitle(title);
		para.setCtnt(ctnt);
		para.setI_student(i_student);
		//BoardDAO.updateList(para);
		if(i_board==0) {
			BoardDAO.insertList(para);
		}else {
			BoardDAO.updateList(para);
		}
		

		// request.setAttribute("data",BoardDAO.insertList(para));
//				String jsp = "/WEB-INF/view/boardRegmod.jsp";
//				request.getRequestDispatcher(jsp).forward(request, response);
		response.sendRedirect("/BoardListSer");
		
	}

}
