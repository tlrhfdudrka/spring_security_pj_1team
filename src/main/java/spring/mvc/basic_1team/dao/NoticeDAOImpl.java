package spring.mvc.basic_1team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.NoticeDTO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 게시글 목록
	@Override
	public List<NoticeDTO> noticeList(Map<String, Object> map) {
		System.out.println("NoticeDAOImpl - noticeList");
		List<NoticeDTO> list = sqlSession.selectList("spring.mvc.basic_1team.dao.NoticeDAO.noticeList", map);
		return list;
	}

	
	// 게시글 갯수 구하기
	@Override
	public int noticeCnt() {
		System.out.println("NoticeDAOImple - noticeCnt");
		
		int total = sqlSession.selectOne("spring.mvc.basic_1team.dao.NoticeDAO.noticeCnt");
		return total; 
	}

	
	// 조회수 증가
	@Override
	public void plusReadCnt(int notice_num) {
		System.out.println("NoticeDAOImpl - plusReadCnt");
		sqlSession.update("spring.mvc.basic_1team.dao.NoticeDAO.plusReadCnt", notice_num);
	}
	
	// 게시글 상세 페이지
	@Override
	public NoticeDTO getNoticeDetail(int notice_num) {
		System.out.println("NoticeDAOImpl - getNoticeDetail");
		
		NoticeDTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.NoticeDAO.getNoticeDetail", notice_num);
		return dto;
	}

	// 게시글 수정처리
	@Override
	public int updateNotice(NoticeDTO dto) {
		System.out.println("NoticeDAOImple - updateNotice");
		
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.NoticeDAO.updateNotice", dto);
		System.out.println("updateCnt : " + updateCnt); // 성공:1 실패:0
		return updateCnt;
	}

	// 게시글 삭제처리
	@Override
	public int deleteNotice(int notice_num) {
		System.out.println("NoticeDAOImpl - deleteNotice");
		
		int deleteCnt = sqlSession.update("spring.mvc.basic_1team.dao.NoticeDAO.deleteNotice", notice_num);
		System.out.println("deleteCnt : " + deleteCnt); // 성공:1 실패:0
		return deleteCnt;
	}

	// 게시글 작성처리
	@Override
	public int writeNotice(NoticeDTO dto) {
		System.out.println("NoticeDAOImpl - writeNotice");
		
		int insertCnt = sqlSession.insert("spring.mvc.basic_1team.dao.NoticeDAO.writeNotice", dto);
		System.out.println("insertCnt : " + insertCnt); // 성공:1 실패:0
		return insertCnt;
	}
}
