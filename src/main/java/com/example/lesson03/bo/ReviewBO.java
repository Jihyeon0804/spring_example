package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	// 조회하기(select)
	// input : id
	// output : Review(단건)
	public Review getReview(int id) {
		return reviewMapper.selectReview(id);
	}
	
	// insert
	// input : Review(단건)
	// output : int(insert가 성공된 행의 개수)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	// addReviewAsField(4, "콤비네이션R", "김비다", 5.0, "역시 맛있다!!!")
	public int addReviewAsField(int storeId, String menu, String userName,
							Double point, String review) {
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// update
	// input : id, review
	// output : int(update가 성공된 행의 개수)
	public int updateReviewById(int id, String review) {
		return reviewMapper.updateReviewById(id, review);
	}
	
	// delete
	// input : id
	// output : X
	// return type을 int로 해도 상관X
	public void deleteReviewById(int id) {
		reviewMapper.deleteReviewById(id);
	}
	
}
