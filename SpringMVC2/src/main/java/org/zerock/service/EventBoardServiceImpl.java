package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;
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
	

	@Override
	public void register(EventVO event) {
		mapper.register(event);

	}

	@Override
	public EventVO get(int bno) {
		return mapper.get(bno);
	}

	@Override
	public int update(EventVO event) {
		return mapper.update(event);

	}

	@Override
	public int delete(int bno) {
		return mapper.delete(bno);

	}

//	@Override
//	public List<EventVO> getList() {
//
//		log.info("getList..........");
//
//		return mapper.getList();
//	}

	@Override
	public List<EventVO> getList(Criteria cri) {

	log.info("get List with criteria: " + cri);

	return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

}
