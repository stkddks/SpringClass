package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;
import org.zerock.domain.PageDTO;
import org.zerock.service.EventBoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller		
@Log4j
@RequestMapping("/eventboard/*")		
@AllArgsConstructor
public class EventBoardController {

	private EventBoardService service;
	
	@GetMapping("/register")
	public void register() {
	}
	
    @PostMapping("/register")	// 등록에 대한 처리
    public String register(EventVO event, RedirectAttributes rttr) {
    	service.register(event);
    	rttr.addFlashAttribute("result", event.getBoardNo());
    	return "redirect:/eventboard/list";
    }

	@GetMapping("/list")
	public void getList(Criteria cri, Model model) {
//		log.info("list: " + cri);
		model.addAttribute("list", service.getList(cri));
		int total = service.getTotal(cri);
//		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

    @GetMapping({"/get","/update"})
    public void get(@RequestParam("boardNo")int bno,@ModelAttribute("cri") Criteria cri,Model model) {
 	   log.info("/get or modify");
 	   model.addAttribute("event",service.get(bno));
    }

    @PostMapping("/update")
	public String update(EventVO event,Criteria cri, RedirectAttributes rttr) {
		
		int count = service.update(event);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		return "redirect:/eventboard/list";
	}

    @PostMapping("/delete")
	public String delete(@RequestParam("bno") int bno,Criteria cri, RedirectAttributes rttr) {
		
		int count = service.delete(bno);
		
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		return "redirect:/eventboard/list";
	}
	
//  @GetMapping("/list")		// 목록에 대한 처리
//  public void list(Model model) {
//  	log.info("list");
//  	model.addAttribute("list", service.getList());
//  }

    
//  @GetMapping("/get")			// 상세보기에 대한 처리
//  public void eventGet(@RequestParam("bno") Long bno, Model model) {
//  	log.info("/get  ");
//  	model.addAttribute("event", service.get(bno));
//  }

//  @PostMapping("/update")		// 수정에 대한 처리
//  public String eventUpdate(EventVO event, RedirectAttributes rttr) {
//  	log.info("modify:" + event);
// 
//  	if (service.modify(event)) {
//  		rttr.addFlashAttribute("result", "success");
//  	}
//  	return "redirect:/eventboard/list";
//  }

    
//  @PostMapping("/delete")		// 삭제에 대한 처리
//  public String EventDelete(@RequestParam("bno") Long bno, RedirectAttributes rttr)
//  {
//
//  	log.info("remove..." + bno);
//  	if (service.remove(bno)) {
//  		rttr.addFlashAttribute("result", "success");
//  	}
//  	return "redirect:/eventboard/list";
//  }
  
    
}
