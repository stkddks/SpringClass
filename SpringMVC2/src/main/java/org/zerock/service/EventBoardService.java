package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;

public interface EventBoardService {
	public abstract void register(EventVO event);
	public abstract EventVO get(Long bno);
	public abstract int update(EventVO board);
	public abstract int delete(Long bno);
//	public abstract List<EventVO> getList();
	public abstract List<EventVO> getList(Criteria cri);
	 public abstract int getTotal(Criteria cri);

}
