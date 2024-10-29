package com.yedam.app.board.service;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private Integer bno; 		// 게시글번호 PK
	private String title; 		// 게시글제목 NOT NULL
	private String content;		// 게시글 내용
	private String writer;	 	// 게시글 작성자 NOT NULL
	private Date regdate; 		// 게시글 작성일자 NOT NULL
	private Date updatedate; 	// 게시글 수정일자
	private String image; 		// 첨부 이미지 파일
}
