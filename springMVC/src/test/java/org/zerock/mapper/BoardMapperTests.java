package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("new writer");
		mapper.insert(board);
		log.info(board);

	}

//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("new title select key");
//		board.setContent("new content select key");
//		board.setWriter("new writer");
//		mapper.insertSelectKey(board);
//		log.info(board);
//	}
	
	@Test
	  public void testRead() {
	  //존재하는 게시물 번호로 테스트
	  BoardVO board = mapper.read(5L);		// Long타입의 5번의 데이터를 가져와라!
	  log.info(board);
	  }
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT:"+mapper.delete(3L));
	}

	
	@Test
	  public void testUpdate() {
	  BoardVO board = new BoardVO();
	  //실행전 존재하는 번호인지 확인할 것
	  board.setBno(5L);
	  board.setTitle("update title");
	  board.setContent("update content");
	  board.setWriter("update writer");
	  
	  int count = mapper.update(board);
	  log.info("UPDATE COUNT:"+count);
	  }

}