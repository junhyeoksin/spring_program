package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	
	private final BoardService service;
	
	@GetMapping("/list")   //목록
	public void list(Model model) {
		log.info("list...........test");
		model.addAttribute("list", service.getList());
		
	}
	@PostMapping("/register")  //게시물 등록
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("board테스트.........: " + board);
		
		Long bno = service.register(board);
		log.info("bno테스트...........: " + bno);
		
		rttr.addFlashAttribute("result", bno);  //한번만 전송됨 = 세션쪽에서 없애야함
		
		return "redirect:/board/list";
		
	}
	@PostMapping("/modify")
	public String modify(BoardVO baord, RedirectAttributes rttr) {
		int count = service.modify(baord);
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
		int count = service.remove(bno);
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	
}
