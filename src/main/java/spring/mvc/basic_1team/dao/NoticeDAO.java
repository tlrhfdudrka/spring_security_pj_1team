package spring.mvc.basic_1team.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.basic_1team.dto.NoticeDTO;

public interface NoticeDAO {
	
	// Cnt로 주고받기때문에 int형인것임

	// 게시글 목록
	public List<NoticeDTO> noticeList(Map<String, Object> map); // 게시글 한개가 dto 한개라서 dto를 담고있는 list가 자료형이 되는것
	
	// 게시글 갯수 구하기
	public int noticeCnt();
	
	// 조회수 증가
	public void plusReadCnt(int notice_num);
	
	// 게시글 상세 페이지
	public NoticeDTO getNoticeDetail(int notice_num);
	
	// 게시글 수정처리
	public int updateNotice(NoticeDTO dto);
	
	// 게시글 삭제처리
	public int deleteNotice(int notice_num);
	
	// 게시글 작성처리
	public int writeNotice(NoticeDTO dto);
}
