package com.koreait.board.db;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	public static BoardVO vo = null;
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
				int i_board = rs.getInt("i_board");
				String title = rs.getNString("title");
				String ctnt = rs.getNString("ctnt");
				String i_student = rs.getString("i_student");
				BoardVO vo = new BoardVO();
				
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
	
	public static BoardVO detailBoardList(BoardVO para){
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//int intI_board = Integer.parseInt(para);
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
	
	public static void insertList(BoardVO para) {
		Connection conn = null;
		PreparedStatement ps= null;
		
		String sql = "insert into t_board(i_board, title,ctnt, i_student) "+
	    		"select nvl(max(i_board),0)+ 1,?,?,? from t_board";
		try{
	    	conn = DBCon.getCon();
	    	ps = conn.prepareStatement(sql);
	    	
	    	ps.setString(1, para.getTitle());
	    	ps.setString(2, para.getCtnt());
	    	ps.setString(3, para.getI_student());
	    	ps.executeUpdate();
	    }catch(Exception e){
	    	e.printStackTrace();
	    }finally {
	    	DBCon.close(conn, ps);
	    }
//		return vo;
	}
}
