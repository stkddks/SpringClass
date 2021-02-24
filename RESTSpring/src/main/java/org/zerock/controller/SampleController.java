package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j		// 처음 imoort 하면 에러난다. pome.xml가서 삭제해주기
public class SampleController {

	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE:"+MediaType.TEXT_PLAIN_VALUE);
		return "안녕하세요";
	}
}

/*
기존의 @Controller는 문자열을 반환하는 경우에는 JSP파일의 이름으로 처리하지만 
@RestController의 경우에는 순수한 데이터가 됩니다. @GetMapping에 사용된 produces속성은
해당 메서드가 생산하는 MIME타입을 의미합니다. 예제와 같이 문자열로 직접 지정할수도 있고,
메서드내의 MediaType이라는 클레스를 이용할수도 있습니다.
프로젝트의 실행은 이전 예제들과 같이 /경로로 실행되도록 하고, 브라우저를 통해서 
/경로로 실행되도록 하고 브라우저를 통해서 '/sample/getText를 호출합니다.

*/