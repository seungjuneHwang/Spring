package com.test.springmvc_board.bean;

public class BoardBean {
	private int board_idx;
	private String board_subject;
	private String board_content;
	private int board_writer_idx;
	private String board_writer_name;
	
	public int getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(int board_idx) {
		this.board_idx = board_idx;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public int getBoard_writer_idx() {
		return board_writer_idx;
	}
	public void setBoard_writer_idx(int board_writer_idx) {
		this.board_writer_idx = board_writer_idx;
	}
	public String getBoard_writer_name() {
		return board_writer_name;
	}
	public void setBoard_writer_name(String board_writer_name) {
		this.board_writer_name = board_writer_name;
	}
	
	
}
