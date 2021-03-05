package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.Board2VO;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;

public interface EventBoardMapper {

//	 public List<EventVO> getList();
	 public List<Board2VO> getListWithPaging(Criteria cri);
	 public void register(EventVO event);
	 public EventVO get(int boardNo);
	 public int delete(int boardNo);
	 public EventVO getUpdate(int boardNo);
	 public int postUpdate(EventVO event);
	 public int getTotalCount(Criteria cri);
//	 public int boardSearch(Long boardNo);
//	 public void insertSelectKey(EventVO event);
}
