package org.zerock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller // @Controller 어노테이션이 붙게되면 이제 BoardController가 서블릿이 되는 것이다. // 서블릿에 대한 설정은
			// servlet-context.xml에 있다.
@Log4j // 생성자함수를 위한 어노체이션
@RequestMapping("/board/*") // mapping은 변환을 뜻한다. /board/* 즉, 모든파일을 변환하겠다 라는 의미. (제어를 하겠다)
@AllArgsConstructor
// @AllArgsConstructor를 이용해서 생성자를 만들고 자동으로 주입하도록 합니다. 
// (만일 생성자를 만들지 않을 경우에는 @Setter(onMethod_ = {@Autowired})를 이용해서 처리합니다. 

public class BoardController {

	private BoardService service;

//	@GetMapping("/list") // 4점대 버전에서 get방식을 사용하는 법
//	public void list(Model model) { // 목록에 대한 처리와 테스트
//		log.info("list");
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
	log.info("list:"+cri);
	model.addAttribute("list", service.getList(cri));
	//model.addAttribute("pageMaker", new PageDTO(cri, 123));		//추가
	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
	}

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("get or modify");
		model.addAttribute("board", service.get(bno));
	}

	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {

		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}

}