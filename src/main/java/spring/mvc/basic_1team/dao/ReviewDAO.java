package spring.mvc.basic_1team.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.basic_1team.dto.ReviewDTO;

public interface ReviewDAO {
	
	// 리뷰 게시글 목록
	public List<ReviewDTO> reviewList(Map<String, Object> map);

	
	// 리뷰 개시글 갯수 구하기
	public int boardCnt();
	
	// 리뷰 게시글 상세페이지
	public ReviewDTO getBoardDetail(int review_num);
	
	// 리뷰 게시글 수정처리
	public int updateReview(ReviewDTO dto);
	
	// 리뷰 게시글 삭제 처리
	public int deletReview(int num);
	
	// 리뷰 게시글 작성 처리
	public int writeReview(ReviewDTO dto);
	
}
