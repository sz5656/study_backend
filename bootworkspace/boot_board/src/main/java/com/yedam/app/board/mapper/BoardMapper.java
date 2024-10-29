package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	//전체 조회
	public List<BoardVO> selectBoardList();
	
	//단건 조회 : 조건 - bno
	public BoardVO selectBoard(BoardVO boardVO);
	
	//등록 : 대상 - bno(selectkey), title, contents, writer, regdate, image
	public int insertBoard(BoardVO boardVO);
}
