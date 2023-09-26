package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@RequestMapping("/lesson04/ex01")
@Controller		// jsp로 보낼 때는 @Responsebody가 없어야 한다.
public class Lesson04Ex01Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원가입 페이지
	// 요청 URL : http://localhost/lesson04/ex01/sign-up-view
//	@RequestMapping("/sign-up-view")	// get과 post 방식 둘 다 허용
	@RequestMapping(path = "/sign-up-view", method = RequestMethod.GET)		// get 방식만 허용
	public String signUpView() {
		return "lesson04/signUp";	// jsp view 경로
	}
	
	// 회원가입 수행(db insert) 후 결과 페이지로 이동
	// form 태그가 보내주는 주소 (view X)
	// 요청 URL : http://localhost/lesson04/ex01/sign-up
//	@RequestMapping(path = "/sign-up", method = RequestMethod.POST)
	@PostMapping("/sign-up")
	public String signUp(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value="introduce", required=false) String introduce) {
		
		// DB Insert ; insert하기 전에 응답 확인 먼저 하기
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		// 응답 확인
		return "lesson04/signUpResult";
	}
	
	
	// 최신 가입자 1명 가져오는 페이지
	// 요청 URL : http://localhost/lesson04/ex01/get-latest-user-view
	@GetMapping("/get-latest-user-view")
	public String getLatestUserView(Model model) {
		//DB select 조회
		User user = userBO.getLatestUser();
		model.addAttribute("result", user);
		model.addAttribute("title", "최신 유저 정보");
		return "lesson04/getLatestUser";	// 결과 jsp 경로
	}
	
}
