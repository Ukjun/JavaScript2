package com.koreait.board.db;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	public static BoardVO vo = null;
	
	//데이터 목록 리스트를 불러온다 (반환타입은 목록전체이기때문에 리스트로 정함)
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select i_board, title, ctnt, i_student from t_board order by i_board";
		
		try {
			conn = DBCon.getCon();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				//갑 불러오기
				int i_board = rs.getInt("i_board");
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				String i_student = rs.getString("i_student");
				BoardVO vo = new BoardVO();
				
				
				//값 입력
				vo.setI_board(i_board);
				vo.setTitle(title);
				vo.setCtnt(ctnt);
				vo.setI_student(i_student);
				list.add(vo);
			}	
		}catch(Exception e) {
			DBCon.close(conn, ps, rs);
		}
		return list;
	}
	
	
	// 해당 항목 내용 불러오기 
	public static BoardVO detailBoardList(BoardVO para){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int intI_board = Integer.parseInt(para);
		
		//i_board가 일치하는 나머지 항목 불러오기 
		String sql = "select title, ctnt, i_student from t_board where i_board=?";
		try {
			conn = DBCon.getCon();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, para.getI_board());
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				vo = new BoardVO();
				vo.setI_board(para.getI_board());
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setI_student(rs.getString("i_student"));
			}
		}catch(Exception e){
			DBCon.close(conn, ps, rs);
		}
		return vo;
	}
	
	
	// 글쓰기 추가내용 입력 
	public static int insertList(BoardVO para) {
		Connection conn = null;
		PreparedStatement ps= null;
		
		int result = 0;
		//seq = 해당 시퀀스 만들어서 클릭시마다 숫자 늘어나게 설정할수있다.
		String sql = "insert into t_board(i_board, title,ctnt, i_student) "+
	    		"values (seq_board.nextval,?,?,?)";
		try{
	    	conn = DBCon.getCon();
	    	ps = conn.prepareStatement(sql);
	    	
	    	ps.setString(1, para.getTitle());
	    	ps.setString(2, para.getCtnt());
	    	ps.setString(3, para.getI_student());
	    	result =ps.executeUpdate();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally {
	    	DBCon.close(conn, ps);
	    }
		System.out.println("insert result : " + result);
		return result;
//		return vo;
	}
	
	
	// 해당 내용 수정할때 쓰는 문장 
	public static int updateList(BoardVO para){
		Connection conn = null;
		PreparedStatement ps= null;
		int intI_board = para.getI_board();
		int result = 0;
		String sql = "update t_board set title=?,ctnt=? where i_board="+intI_board;
		try {
			conn = DBCon.getCon();
	    	ps = conn.prepareStatement(sql);
	    	ps.setString(1,para.getTitle());
	        ps.setString(2,para.getCtnt());
	        result = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBCon.close(conn, ps);
		}
		System.out.println("update result : " + result);
		return result;
	}
	
	
	public static int deleteList(BoardVO para) {
		Connection conn = null;
		PreparedStatement ps= null;
		int intI_board = para.getI_board();
		String sql = "delete from t_board where i_board= ?";
		int result = 0;
		try {
			conn = DBCon.getCon();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,intI_board);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBCon.close(conn, ps);
		}
		return result;
	}
}
