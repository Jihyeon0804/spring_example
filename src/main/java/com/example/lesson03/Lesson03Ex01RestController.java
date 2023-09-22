package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	// 하나의 행만 가져올 것임
	// 요청 URL : http://localhost/lesson03/ex01	// 파라미터 설정 후 이 주소로 들어오면 400 error
	// 요청 URL : http://localhost/lesson03/ex01?id=5
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id								// 필수 파라미터
//			@RequestParam(value="id") int id						// 필수 파라미터, required=true 생략 가능
//			@RequestParam(value="id", required=true) int id 		// 필수 파라미터
//			@RequestParam(value="id", required=false) Integer id	// 비필수 파라미터; null도 가능
//			@RequestParam(value="id", defaultValue="1") int id		// 비필수 파라미터; null인 경우 디폴트 값으로 id 지정 (최종적으로는 null일 수 없으니 int형으로 지정)
			) {
		return reviewBO.getReview(id);	// response body => json
	}
}
