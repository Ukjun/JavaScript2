package com.koreait.board.vo;

public class BoardVO {
	private int i_board;
	private String title;
	private String ctnt;
	private String i_student;
	private String t_date;
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	public int getI_board() {
		return i_board;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getI_student() {
		return i_student;
	}
	public void setI_student(String i_student) {
		this.i_student = i_student;
	}
}
