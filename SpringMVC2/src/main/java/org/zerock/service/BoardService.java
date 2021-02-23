package org.zerock.service;
import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
 public abstract void register(BoardVO board);
 public abstract BoardVO get(Long bno);
 public abstract int modify(BoardVO board);
 public abstract int remove(Long bno);
// public abstract List<BoardVO> getList();
 public abstract List<BoardVO> getList(Criteria cri);
 public abstract int getTotal(Criteria cri);

}

/*
BoardService 는 비지니스계층
비즈니스 계층은 고객의 요구사항을 반영하는 계층
프레젠테이션 계층과 영속계층의 중간다리 역할 
영속계층은 데이터베이스를 기준으로 해서 설계를 나눠 구현하지만 
비즈니스 계층은 로직을 기준으로 해서 처리하게 됩니다. 
*/