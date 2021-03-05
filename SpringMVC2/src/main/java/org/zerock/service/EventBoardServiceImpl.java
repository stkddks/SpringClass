package org.zerock.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.zerock.domain.Board2VO;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;
import org.zerock.domain.UserVO;
import org.zerock.mapper.EventBoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EventBoardServiceImpl implements EventBoardService {

	@Setter(onMethod_ = @Autowired)
	private EventBoardMapper mapper;
	
//	@Resource(name="userVO")
//	@Lazy
//	private UserVO userVO;

	@Override
	public void register(EventVO event) {
//		String userNickname = userVO.getUserNickname();
//		event.setUserNo(userVO.getUserNo());
		mapper.register(event);
	}	//끝

	@Override
	public EventVO get(int bno) {
		return mapper.get(bno);
	}
	
	@Override
	public EventVO getUpdate(int bno) {
		return mapper.getUpdate(bno);
	}


	@Override
	public int postUpdate(EventVO event) {
		return mapper.postUpdate(event);

	}

	@Override
	public int delete(int bno) {
		return mapper.delete(bno);

	}

	@Override
	public List<Board2VO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}	//끝		//즐찾 추가하기
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

}
