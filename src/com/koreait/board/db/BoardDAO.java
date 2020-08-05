package com.koreait.board.db;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.*;

import com.koreait.board.vo.BoardVO;

public class BoardDAO {
	public static List<BoardVO> selBoardList(){
		List<BoardVO> list = new ArrayList();
		
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
}
