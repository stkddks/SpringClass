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
  @Setter(onMethod = @__({ @Autowired }))
  private BoardMapper mapper;
  
  @Test
  public void testGetList() {
    mapper.getList().forEach(board -> log.info(board));
  }
  
  @Test
  public void testInsert() {
  BoardVO board = new BoardVO();
  board.setTitle("새로작성하는글");
  board.setContent("새로작성하는내용");
  board.setWriter("newkh");
  mapper.insert(board);
  log.info(board);	//Lombok이 만들어주는 toString()을 이용해서 bno멤버변수(인스턴스변수)의 값을 알아보기 위함
  }

  @Test
  public void testInsertSelectKey() {
  BoardVO board = new BoardVO();
  board.setTitle("새로작성하는글 select key");
  board.setContent("새로작성하는내용 select key");
  board.setWriter("newkh");
  mapper.insertSelectKey(board);
  log.info(board);
  }
  
  @Test
  public void testRead() {
  //존재하는 게시물 번호로 테스트
  BoardVO board = mapper.read(5L);	// 5번 데이터 읽음
  log.info(board);
  }
  
  @Test
  public void testDelete() {
	  log.info("DELETE COUNT:"+mapper.delete(3L));	//3번 데이터 삭제
  }


}