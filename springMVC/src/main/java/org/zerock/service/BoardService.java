package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {

	public abstract void register(BoardVO board);

	public abstract BoardVO get(Long bno);

	public abstract boolean modify(BoardVO board);

	public abstract boolean remove(Long bno);

//	public abstract List<BoardVO> getList();

	public abstract List<BoardVO> getList(Criteria cri);

}
