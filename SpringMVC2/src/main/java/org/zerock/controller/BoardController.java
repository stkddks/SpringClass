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

import lombok.extern.log4j.Log4j;
import lombok.AllArgsConstructor;	// BoardController는 BoardService에 대해서 의존적이므로 @AllArgsConstructor를 이용해서 생성자를 만들고 자동으로 주입 

@Controller		// @Controller어노테이션을 추가해서 스프링의 빈으로 인식할수있게 한다
@Log4j
@RequestMapping("/board/*")		// @RequestMapping을 통해서 '/board'로 시작하는 모든 처리를 BoardController가 하도록 지정
public class BoardController {

	private BoardService service;
	
    @GetMapping("/list")		// 목록에 대한 처리
    public void list(Model model) {
    	log.info("list");
    	model.addAttribute("list", service.getList());
    }
    
    @PostMapping("/register")	// 등록에 대한 처리
    public String register(BoardVO board, RedirectAttributes rttr) {
    	log.info("register: " + board);
    	service.register(board);
    	rttr.addFlashAttribute("result", board.getBno());
    	return "redirect:/board/list";
    }
    
    @GetMapping("/get")		// 조회에 대한 처리
	public void get(@RequestParam("bno") Long bno, Model model) {
	
	 log.info("/get  ");
	 model.addAttribute("board", service.get(bno));
    }
    
    @PostMapping("/modify")		// 수정에 대한 처리
    public String modify(BoardVO board, RedirectAttributes rttr) {
    	log.info("modify:" + board);
   
    	if (service.modify(board)) {
    		rttr.addFlashAttribute("result", "success");
    	}
    	return "redirect:/board/list";
    }
    
    @PostMapping("/remove")		// 삭제에 대한 처리
    public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr)
    {

    	log.info("remove..." + bno);
    	if (service.remove(bno)) {
    		rttr.addFlashAttribute("result", "success");
    	}
    	return "redirect:/board/list";
    }

}

/*
BoardController는 프레젠테이션계층. BoardController servlet역할이다
프레젠테이션계층은 웹 구현 계층이다
비즈니스 계층의 구현까지 모든 테스트가 진행되었다면 이제 남은 작업은 프레젠테이션계층인 웹의 구현 
웹은 앞에서 실습한 내용을 기준으로 현재 프로젝트에 반영
*/