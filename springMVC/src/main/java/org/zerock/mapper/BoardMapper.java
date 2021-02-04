package org.zerock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
//  @Select("select * from tbl_board where bno > 0")
	// 우리는 xml파일에 코딩해놨으니까 굳이 여기서 또 코딩하지 않아도 된다.
  public abstract List<BoardVO> getList();	//getList라는 객체를 만들었으니 우리는 이 친구를 상속받아서 쓸 클래스가 필요하다
  public abstract void insert(BoardVO board);
  // 추상메서드 인터페이스에 추가
  public abstract void insertSelectKey(BoardVO board);	// insertSelectKey를 추상메소드로 일단 하나 생성
  public abstract BoardVO read(Long bno);
  public abstract int delete(Long bno);
  public abstract int update(BoardVO board);

}