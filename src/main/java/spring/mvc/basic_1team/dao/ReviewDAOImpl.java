package spring.mvc.basic_1team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.ReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 리뷰 게시글 목록
	@Override
	public List<ReviewDTO> reviewList(Map<String, Object> map) {
		System.out.println("ReviewDAOImpl - reviewList");
		
		List<ReviewDTO> list =  sqlSession.selectList("spring.mvc.basic_1team.dao.ReviewDAO.reviewList", map);
	    System.out.println("list : =======" + list);
		      
		      // 5. list 리턴
		      return list;
		   }

	// 리뷰 게시글 갯수 구하기
	@Override
	public int boardCnt() {
		
		 int total = sqlSession.selectOne("spring.mvc.basic_1team.dao.ReviewDAO.boardCnt");
	      
	      return total;
	   }


	// 리뷰 게시글 상세페이지
	@Override
	public ReviewDTO getBoardDetail(int review_num) {
		System.out.println("ReviewDAOImpl - getBoardDetail");
		
		ReviewDTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.ReviewDAO.getBoardDetail", review_num);
		
	      return dto;
	   }


	// 리뷰 게시글 수정처리
	@Override
	public int updateReview(ReviewDTO dto) {
		System.out.println("ReviewDAOImpl - updateReview");
		
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.ReviewDAO.updateReview", dto);
		
		return updateCnt;
	}

	// 리뷰 게시글 삭제 처리
	@Override
	public int deletReview(int review_num) {
		System.out.println("ReviewDAOImpl - deletReview");
		
		int deleteCnt = sqlSession.insert("spring.mvc.basic_1team.dao.ReviewDAO.deletReview", review_num);
				
			String sql = "UPDATE pj_review_tbl "
					+      " SET show = 'n' "
					+    " WHERE review_num = ? ";
			
		
		return deleteCnt;
	}

	// 리뷰 게시글 작성 처리
	@Override
	public int writeReview(ReviewDTO dto) {
		System.out.println("ReviewDAOImpl - writeReview");
		
		int insertCnt = sqlSession.insert("spring.mvc.basic_1team.dao.ReviewDAO.writeReview", dto);	
		
		return insertCnt;
	}

}
