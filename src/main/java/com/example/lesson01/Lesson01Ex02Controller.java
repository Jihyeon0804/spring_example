package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller		// jsp를 뿌릴 때는 @ResponseBody가 없는 @Controller를 사용해야 한다.
public class Lesson01Ex02Controller {

	// 요청 URL : http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02")	// 요청 주소 (내가 치고 들어오는 주소)
	public String ex02() {
		// jsp 경로를 리턴한다.
 		// return "/WEB-INF/jsp/lesson01/ex02.jsp";
		// prefix와 suffix 제외하고 써야함
		// prefix : /WEB-INF/jsp/
		// suffix : .jsp
		return "lesson01/ex02"; // jsp view의 경로
	}
	
}
