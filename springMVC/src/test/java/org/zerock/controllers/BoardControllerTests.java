package org.zerock.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)

// Test for Controller
@WebAppConfiguration
// @WebAppConfiguration은 servlet의 ServletContext를 이용하기 위해서
// 스프링에서는 WebApplicationContext라는 존재를 이용하기 위해서입니다.

@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j

public class BoardControllerTests {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc; // moc의 뜻은 가짜라는 의미. 즉, 테스트용으로 쓰겠다.

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

//	@Test
//	public void testList() throws Exception {
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
//	}
	
	@Test
	public void testListPaging() throws Exception {

			log.info(mockMvc.perform(
			MockMvcRequestBuilders.get("/board/list")
			.param("pageNum", "2")
			.param("amount", "50"))
			.andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void testRegister() throws Exception {

		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/register").param("title", "테스트 새글 제목")
						.param("content", "테스트 새글 내용").param("writer", "user00"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);

	}

	@Test
	public void tetGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn()
				.getModelAndView().getModelMap());
	}

	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "1").param("title", "update new title")
						.param("content", "update new content").param("writer", "user11"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);

	}

	@Test
	public void testRemove() throws Exception {
		// 삭제전 데이터베이스에 게시물 번호 확인할 것
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "6")).andReturn()
				.getModelAndView().getViewName();
		log.info(resultPage);
	}

}



/*
경우에 따라서는 Controller에 대한 테스트 코드를 작성하는 것에 대해서 거부감을 가지는 경우도 많습니다. 대부분은 일정에 여유가 없다는
이유로 테스트를 작성하지 않는 경우가 많은데 프로젝트를 진행하는 멤버들의 경험치가 낮을수록 테스트를 먼저 진행하는 습관을 가지는 것이
좋습니다. 반복적으로 입력과 수정, WAS의 재시작시간을 고려해보면 Controller 에 대한 테스트를 진행하는 선택이 더 빠른 개발의 결과를 
낳는 경우가 많습니다. 유념하세요.
*/



