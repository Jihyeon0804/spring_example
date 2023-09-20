package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController		// @Controller + @ResponseBody
public class Lesson02Ex01RestController {
	
	// 요청 URL : http://localhost/lesson02/ex01
	@RequestMapping("/lesson02/ex01")	// 요청
	public List<UsedGoods> ex01() { // UsedGoods - DTO(Data Transfer Object : 여러개의 레이어를 타고다니는 객체) or Model or Domain ; 우리는 도메인으로 부를 것임
		List<UsedGoods> usedGoodsList = ;
		return usedGoodsList // 응답; json
	}
}
