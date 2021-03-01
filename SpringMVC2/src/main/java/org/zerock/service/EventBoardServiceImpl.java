package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;
import org.zerock.mapper.EventBoardDAO;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class EventBoardServiceImpl implements EventBoardService {

	@Setter(onMethod_ = @Autowired)
	private EventBoardDAO eventDao;
	

	@Override
	public void register(EventVO event) {
		eventDao.register(event);

	}

	@Override
	public EventVO get(Long bno) {
		return eventDao.get(bno);
	}

	@Override
	public int update(EventVO event) {
		return eventDao.update(event);

	}

	@Override
	public int delete(Long bno) {
		return eventDao.delete(bno);

	}

//	@Override
//	public List<EventVO> getList() {
//
//		log.info("getList..........");
//
//		return eventDao.boardList();
//	}

	@Override
	public List<EventVO> getList(Criteria cri) {

	log.info("get List with criteria: " + cri);

	return eventDao.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return eventDao.getTotalCount(cri);
	}

}
