package spring.mvc.basic_1team.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.basic_1team.dao.NoticeDAOImpl;
import spring.mvc.basic_1team.dto.NoticeDTO;
import spring.mvc.basic_1team.page.PagingNotice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAOImpl dao;
	
	// 게시글 목록
	@Override
	public void noticeListAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeListAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String pageNum = req.getParameter("pageNum");
		
		// 4-1단계. 전체 게시글 갯수 카운트
		PagingNotice pagingNotice = new PagingNotice(pageNum);
		int total = dao.noticeCnt();

		pagingNotice.setTotalCount(total);
		// 4-2단계. 게시글 목록 조회
		int start = pagingNotice.getStartRow();
		int end = pagingNotice.getEndRow();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		
		List<NoticeDTO> list = dao.noticeList(map);
		
		// 5단계. jsp로 처리결과 전달
		model.addAttribute("paging", pagingNotice);
		model.addAttribute("list", list);
	}

	
	// 게시글 상세페이지
	@Override
	public void noticeDetailAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeDetailAction");
		
		// 3단계. get방식으로 전달된 값을 가져온다.
		int num = Integer.parseInt(req.getParameter("notice_num"));
		
		// 5-1단계. 조회수 증가
		dao.plusReadCnt(num);
		
		// 5-2단계. 게시글 상세페이지
		NoticeDTO dto = dao.getNoticeDetail(num);
		
		// 5-2단계. 게시글 상세페이지
		model.addAttribute("dto", dto);
	}

	// 게시글 수정처리
	@Override
	public void noticeUpdateAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeUpdateAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_num(Integer.parseInt(req.getParameter("notice_num")));
		dto.setNotice_num(dto.getNotice_num());
		dto.setNotice_pwd(req.getParameter("notice_pwd"));
		dto.setNotice_title(req.getParameter("notice_title"));
		dto.setNotice_content(req.getParameter("notice_content"));
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.updateNotice(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("dto", dto);
	}

	// 게시글 삭제처리
	@Override
	public void noticeDeleteAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeDeleteAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		int num = Integer.parseInt(req.getParameter("notice_num"));
		
		// 5단계. 게시글 삭제 처리 후 컨트롤러에서 list로 이동
		dao.deleteNotice(num);
	}

	// 게시글 작성 처리
	@Override
	public void noticeInsertAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - noticeInsertAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		NoticeDTO dto = new NoticeDTO();
		
		dto.setUser_id(req.getParameter("user_id"));
		dto.setNotice_title(req.getParameter("notice_title"));
		dto.setNotice_content(req.getParameter("notice_content"));
		
		// 5단계. 게시글 작성처리 후 컨트롤러에서 list로 이동
		dao.writeNotice(dto);
	}
}
