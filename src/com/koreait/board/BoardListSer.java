package com.koreait.board;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListSer
 * 서블릿 만드는법 우클릭 후 Servlet 클릭한후 클래스명 이름 주듯이 이름 설정을 한다.
 * 멤버 필드
 */
@WebServlet("/BoardListSer")
public class BoardListSer extends HttpServlet {
	//private public protected를 지우면 자동으로 default가 설정이된다.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * RequestDispatcher : servlet <> jsp간의 내용을 살려서 보낸다
	 * 
	 * sendDirect는 내용을 살려서 못보낸다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strI_board = request.getParameter("i_board");
		System.out.println("Servlet i_board:"+ strI_board);
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
		// jsp의 내용을 가져온다(인터넷상에선 파일 내용등등을 유추할수 없게 가져온다)
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
