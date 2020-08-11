package com.koreait.board;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board.db.BoardDAO;
import com.koreait.board.db.DBCon;
import com.koreait.board.vo.BoardVO;

/**
 * Servlet implementation class BoardListSer
 * 서블릿 만드는법 우클릭 후 Servlet 클릭한후 클래스명 이름 주듯이 이름 설정을 한다.
 * 멤버 필드
 */
@WebServlet("/BoardListSer")
//주소값 매핑
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
	 * RequestDispatcher : servlet <> jsp간의 내용을 살려서 보낸다 / 주소값이 변하지 않음 // doGet에서 전송을하면 get방식 doPost에서 전송을하면 post방식으로 전송한다
	 * 
	 * sendDirect는 내용을 살려서 못보낸다.(소멸되고 새로 생성되서 보낸다) / 주소값이 변경되서 전송된다.  // 무조건 get방식으로 날리게 된다.
	 * application 서버가 살아나면 살고 서버가 죽으면 죽는 타입
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 띄우는 용도로 doGet을 쓴다.
		String strI_board = request.getParameter("i_board");
		//System.out.println("Servlet i_board:"+ strI_board);
		// TODO Auto-generated method stub
		BoardVO vo = new BoardVO();
		
		try {
			// getCon()에서 throws로 try catch를 넘겨버렸기 때문에 써줘야된다.
			List<BoardVO> list = BoardDAO.selBoardList();
			request.setAttribute("data", list);
//			list = parameter는 object타입이다
			// 리스트 	불러오기 + boardList.jsp로 값과 같이 이동 
			BoardDAO.selBoardList();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/boardList.jsp");
			
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// jsp의 내용을 가져온다(인터넷상에선 파일 내용등등을 유추할수 없게 가져온다) get형식으로 파일을 열떄 사용
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 화면 처리하는 곳에 쓰게된다.
		doGet(request, response);
	}

}
