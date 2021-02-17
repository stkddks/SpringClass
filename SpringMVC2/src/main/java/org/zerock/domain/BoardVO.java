package org.zerock.domain;

import java.util.Date;	// util로 들어가는 것 주의
import lombok.Data;		
// Lombok을 이용해서 생성자와 getter/setter, toString()등을 만들어 내는 방식을 사용합니다. 
// 이를 위해서 @Data 어노테이션을 적용합니다. 

@Data
public class BoardVO {
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private Date updateDate;
}
