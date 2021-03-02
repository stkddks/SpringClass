package org.zerock.mapper;

import java.util.List;
import org.zerock.domain.Criteria;
import org.zerock.domain.EventVO;

public interface EventBoardMapper {

//	 public List<EventVO> getList();
	 public List<EventVO> getListWithPaging(Criteria cri);
	 public abstract void register(EventVO event);
	 public abstract EventVO get(int boardNo);
	 public abstract int delete(int boardNo);
	 public abstract int update(EventVO event);
	 public int getTotalCount(Criteria cri);
//	 public abstract int boardSearch(Long boardNo);
//	 public abstract void insertSelectKey(EventVO event);
}
