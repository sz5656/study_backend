package com.yedam.app.board.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller // Endpoint( URI + Method) + Service + View
public class BoardController {
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	//전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> boards = boardService.getList();
		model.addAttribute("boards",boards);
		return "board/boardList";
	}
	//단건조회 : URI - boardInfo / PARAMETER - BoardVO
	//				/RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(Model model, BoardVO boardVO) {
		BoardVO board = boardService.getInfo(boardVO);
		model.addAttribute("board",board);
		return "board/boardInfo";
	}
	//등록 - 페이지 - URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String addBoard() {
		return "board/boardInsert";
	}
	//등록 - 처리 - URI - boardInsert / PARAMETER - BoardVO
	//				/RETURN - 단건조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardVO) {
		int result = boardService.insertBoard(boardVO); // result ? getbno() : -1
		String url = "";
		if(result > -1) {
			url = "redirect:/boardInfo?bno="+result; // 성공 => 해당 게시글 단건 조회 이동
		} else {
			url = "redirect:/boardInsert"; // 실패 => 등록페이지 다시 이동
		}
		return url;
	}
}
