package com.example.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.lesson02.domain.UsedGoods;

@Repository
public interface UsedGoodsMapper {
	// DB에서 실제 데이터 가져옴
	// MyBatis Framework
	
	// input(BO-Service) : 파라미터 X (DB 데이터 전체를 요청했으므로)
	// output(BO-Service 결과 돌려줌) : List<UsedGoods>
	public List<UsedGoods> selectUsedGoodsList();
}
