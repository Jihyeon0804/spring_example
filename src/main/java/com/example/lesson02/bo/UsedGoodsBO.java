package com.example.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson02.domain.UsedGoods;
import com.example.lesson02.mapper.UsedGoodsMapper;

@Service	// spring bean
public class UsedGoodsBO {
	
	@Autowired	// spring bean(객체)을 가져오는 것 - DI(Dependency Injection)
	private UsedGoodsMapper usedGoodsMapper;
	
	// input(Controller로 부터 요청 받음) : 파라미터 X (DB 데이터 전체를 요청했으므로)
	// output(Controller한테 돌려줌)	: List<UsedGoods>
	public List<UsedGoods> getUsedGoodsList() {
		return usedGoodsMapper.selectUsedGoodsList(); // 메소드 호출
	}
}
