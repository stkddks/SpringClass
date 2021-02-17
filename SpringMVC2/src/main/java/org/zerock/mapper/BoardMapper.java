package org.zerock.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
  // @Select("select * from tbl_board where bno > 0")
	// XML에 SQL문이 처리되었으니 BoardMapper 인터페이스에 SQL은 제거
  public List<BoardVO> getList();
  public abstract void insert(BoardVO board);
  public abstract void insertSelectKey(BoardVO board);

}
