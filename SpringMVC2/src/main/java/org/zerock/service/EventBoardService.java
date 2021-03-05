package org.zerock.service;

import java.util.List;

import org.zerock.domain.Board2VO;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;

public interface EventBoardService {
	public void register(EventVO event);
	public EventVO get(int bno);
	public EventVO getUpdate(int bno);
	public int postUpdate(EventVO board);
	public int delete(int bno);
//	public List<EventVO> getList();
	public List<Board2VO> getList(Criteria cri);
	public int getTotal(Criteria cri);

}
