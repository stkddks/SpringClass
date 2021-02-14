package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ = @Autowired)		
		//@Setter 는 set함수를 자동으로 코딩하도록 만들어주는 롬복의 어노테이션! // @Autowired 는 자동으로 객체를 주입한는 얘기
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register......" + board);
//		mapper.insertSelectKey(board);		// 얘는 oracle쓸때 (왜? mysql에서는 번호 자동증가를 안썼어. )
		mapper.insert(board);

	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get......" + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......" + board);
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove...." + bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {

		log.info("getList..........");

		return mapper.getList();
	}

}

// BoardService 인터페이스를 구현하는 구현체는 BoardServiceImpl이라는 클레스로 작성합니다. 
// BoardServiceImpl 클레스에 가장 중요한 부분은 @Service라는 어노테이션입니다. 
// @Service 계층구조상 주로 비즈니스 영역을 담당하는 객체임을 표시하기 위해 
// 사용합니다. 작성된 어노테이션은 패키지를 읽어 들이는 동안 처리됩니다. 

// BoardServiceImpl가 정상적으로 동작하기 위해서는 BoardMapper 객체가 필요합니다. 
// 이는 @Autowired와 같이 직접 설정해 줄수 있고, Setter를 이용해서 처리할 수도 있습니다. 
// Lombok을 이용. 
