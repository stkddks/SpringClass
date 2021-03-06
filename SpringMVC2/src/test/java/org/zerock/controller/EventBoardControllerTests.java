package org.zerock.controller;

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

@WebAppConfiguration		// Servlet의 ServletContext를 이용하기 위해서인데, 스프링에서는 WebApplicationContext라는 존재를 이용하기 위해서

@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Log4j

public class EventBoardControllerTests {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before		// @Before어노테이션이 적용된 setUp()에서는 import할때 Junit을 이용해야한다.
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/eventboard/list")).andReturn().getModelAndView().getModelMap());
	}
//	
//	@Test
//	public void testRegister() throws Exception {
//
//		String resultPage = mockMvc
//					.perform(MockMvcRequestBuilders.post("/board/register")
//		.param("title", "test new title")
//		.param("content", "test new content")
//		.param("writer", "user00"))
//		.andReturn().getModelAndView().getViewName();
//
//		log.info(resultPage);
//
//	}
//	
//	@Test
//	public void testGet() throws Exception {
//		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn()
//		.getModelAndView().getModelMap());
//	}
//	
//	@Test
//	public void testModify() throws Exception {
//
//		String resultPage = mockMvc
//		.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "1").param("title", "modify test new title")
//		.param("content", "modify test new title").param("writer", "user00"))
//		.andReturn().getModelAndView().getViewName();
//
//		log.info(resultPage);
//
//	}
//	
//	@Test
//	public void testRemove() throws Exception {
//	// 삭제전 데이터베이스에 게시물 번호 확인할 것
//		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "25")).andReturn()
//				.getModelAndView().getViewName();
//
//		log.info(resultPage);
//	}
	
}