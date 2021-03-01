package org.zerock.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EventVO {
	private int boardNo; // 게시글 번호
	private int boardCategory; // 게시판 번호
	
	private String boardTitle;
	private String boardContent;
	private String boardRegdate;
	private int boardReadcount;

//	서버에있는 파일이름
	private String fileName;
//	클라에서 보내는 파일 데이터
	private MultipartFile uploadFile;
	
	private String thumbnail;
	private int userNo;
}
