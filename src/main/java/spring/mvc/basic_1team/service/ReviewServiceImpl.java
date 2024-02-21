package spring.mvc.basic_1team.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.basic_1team.dao.ReviewDAO;
import spring.mvc.basic_1team.dao.ReviewDAOImpl;
import spring.mvc.basic_1team.dto.ReviewDTO;
import spring.mvc.basic_1team.page.PagingNotice;


@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO dao;
	private PagingNotice page;
	
	
	// 리뷰 게시글 목록
	@Override
	public void reviewListAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - reviewListAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String pageNume = req.getParameter("pageNum");
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		//ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5-1단계. 전체 게시글 갯수 카운트
		PagingNotice pagingNotice = new PagingNotice(pageNume);
		int total = dao.boardCnt();
		System.out.println("total : " + total);
		pagingNotice.setTotalCount(total);
		
		// 5-2단계. 게시글 목록 조회
		int start = pagingNotice.getStartRow();
		int end = pagingNotice.getEndRow();
		
		//System.out.println("start : " + start);
		//System.out.println("end : " + end);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		List<ReviewDTO> list = dao.reviewList(map);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("paging", pagingNotice);
		model.addAttribute("list", list);
		
	}

	// 리뷰 게시글 상세페이지
	@Override
	public void reviewDetailAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - reviewDetailAction");
		
		// 3단계. get방식으로 전달된 값을 가져온다.
		int num = Integer.parseInt(req.getParameter("review_num"));
		System.out.println("num------------>" + num);
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		//ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5-1단계. 조회수 증가
		
		// 5-2단계. 게시글 상세페이지
		ReviewDTO dto = dao.getBoardDetail(num);
				
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("dto", dto);
	}

	
	// 리뷰 게시글 수정처리 화면
	@Override
	public void ReviewUpdate(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - ReviewUpdate");
		
		// 3단계. 화면에서 입력받은 값, hidden을 가져온다.
	    int num = Integer.parseInt(req.getParameter("hidden_num"));
	    System.out.println("num---------->" + num);
	    //int pageNum = Integer.parseInt(req.getParameter("pageNum"));
				
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		//ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		ReviewDTO dto = dao.getBoardDetail(num);	
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("dto", dto);
		//req.setAttribute("pageNum", pageNum);
	}

	

	// 리뷰 게시글 수정처리
	@Override
	public void ReviewUpdateAction(MultipartHttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - ReviewUpdateAction");
		
		 
		// 3단계. 화면에서 입력받은 값, hidden값을 가져온다.
		int hidden_num = Integer.parseInt(req.getParameter("hidden_num"));
		String hidden_img = req.getParameter("hidden_img");
		//String uploadPdImg = (String) req.getAttribute("fileName");
		//-------------------------------------------------
		
		//-------------------------------------------------
		
		// 추가 START : JSP의 ImgeUploadHandler.java 기능 ----------------------------
	      MultipartFile file = req.getFile("review_img"); 
	      System.out.println("file : " + file);
	      
	      // input 경로
	      String saveDir = req.getSession().getServletContext().getRealPath("/resources/upload/");
	      System.out.println("saveDir" + saveDir);
	      

	      // 이미지 추가를 위한 샘플이미지 경로(updload 폴더 우클릭 > properties > Location 정보 복사해서 붙여넣기) 주의 맨뒤 \\ 추가
	      String realDir = "D:\\dev\\workspace-spring\\spring_security_pj_1team\\src\\main\\webapp\\resources\\upload\\";
	      System.out.println("realDir" + realDir); 	    
	      
	      
	      FileInputStream fis = null;
	      FileOutputStream fos = null;
	      String p_img1 = "";
	      
	      if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
	    	  try {
		    	  file.transferTo(new File(saveDir + file.getOriginalFilename()));
		    	  fis = new FileInputStream(saveDir + file.getOriginalFilename());
		    	  fos = new FileOutputStream(realDir + file.getOriginalFilename());
		    	  
		    	  int data = 0;
		    	  while((data = fis.read()) != -1) {
		    		  fos.write(data);
		    	  }
		    	  // 추가 END : JSP의 ImgeUploadHandler.java 기능 ----------------------------
	    	  } catch(IOException e) {
		    	  e.printStackTrace();
		      } finally {
		    	  if(fis != null) fis.close();
		    	  if(fos != null) fos.close();
		      }  
	    	  
	    	  // 수정 START
		      p_img1 = "/basic_1team/resources/upload/" + file.getOriginalFilename();   // /세번째패키지명/upload경로/파일명(file.getOriginalFilename())   / 파일명만 가져오기. 이게 이제 db로 들어가는것
		      // dto.getPdImg() ==> /spring_pj_ict02/resources/upload/트롬세탁기.jpg
		      System.out.println("dto.review_img() ==>" + p_img1); //dto.getPdImg() ==>/spring_pj_ict02/resources/upload/아이폰12.png
		      // 수정 END
	      }
	      
	      else {
	    	  // 기존 이미지 사용(이미지 수정 안할 경우)
	    	  p_img1 = hidden_img;
	    	  System.out.println("기존 이미지 : " + p_img1);
	    	  
	      }
	      // 반영 끝
		
		System.out.println("hidden_num-----" + hidden_num);
		System.out.println("hidden_img-----" + hidden_img);
		//System.out.println("UploadPdImg-----" + uploadPdImg);
		
		
		
		
//		String strRwImg ="";
		// 이미지를 수정안했을 때
//		if(uploadPdImg == null) {
//			strRwImg = hidden_img;
//		}
//		// 이미지를 수정했을 때
//		else {
//			strRwImg = "/mvc_jsp_shopping/resources/upload/" + uploadPdImg;  
//		}
		
		// dto 생성
		ReviewDTO dto = new ReviewDTO();
		dto.setReview_num(hidden_num);
		System.out.println("hidden_num : " + hidden_num);
		
		dto.setReview_img(p_img1);
		System.out.println("이미지 : " + p_img1);
		
		dto.setReview_title(req.getParameter("review_title"));
		dto.setReview_content(req.getParameter("review_content"));
		//dto.setReview_pwd(req.getParameter("review_pwd"));
		
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		//ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.updateReview(dto);
		
		// 6단계. jsp로 처리결과 전달
		//req.setAttribute("dto", dto);
	}

	// 리뷰 게시글 삭제 처리
	@Override
	public void ReviewDeleteAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		ReviewDTO dto = new ReviewDTO();
		int num = Integer.parseInt(req.getParameter("hidden_num")); 
		
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		//ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.deletReview(num);
		
	}

	
	// 리뷰 게시글 작성 처리
	@Override
	public void ReviewInsertAction(MultipartHttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - ReviewInsertAction");
		
		// 추가 START : JSP의 ImgeUploadHandler.java 기능 ----------------------------
	      MultipartFile file = req.getFile("review_img");
	      System.out.println("출력----------------"+req.getFile("review_img"));
	      System.out.println("file : " + file);	  
	    		  
	   // input 경로
	      String saveDir = req.getSession().getServletContext().getRealPath("/resources/upload/");
	      System.out.println("saveDir" + saveDir);		  
	    	
	      // 이미지 추가를 위한 샘플이미지 경로(updload 폴더 우클릭 > properties > Location 정보 복사해서 붙여넣기) 주의 맨뒤 \\ 추가
	      String realDir = "D:\\dev\\workspace-spring\\spring_security_pj_1team\\src\\main\\webapp\\resources\\upload\\";
	      System.out.println("realDir" + realDir); 	    
	      
	      
	      FileInputStream fis = null;
	      FileOutputStream fos = null;
	      
	    	  try {
		    	  file.transferTo(new File(saveDir + file.getOriginalFilename()));
		    	  fis = new FileInputStream(saveDir + file.getOriginalFilename());
		    	  fos = new FileOutputStream(realDir + file.getOriginalFilename());
		    	  
		    	  int data = 0;
		    	  while((data = fis.read()) != -1) {
		    		  fos.write(data);
		    	  }   
	      
		// 추가 END : JSP의 ImgeUploadHandler.java 기능 ----------------------------  
	      
	    		  
	    // 세션에서 사용자 아이디 가져오기
	    HttpSession session = req.getSession();
	    String sessionID = (String) session.getAttribute("sessionID");
	    
	    System.out.println("user_id=============" + sessionID);
	    
		// 3단계. 화면에서 입력받은 값을 가져온다.
		ReviewDTO dto = new ReviewDTO();
		dto.setUser_id(sessionID);
		dto.setReview_title(req.getParameter("title"));
		dto.setReview_content(req.getParameter("content"));
		
		// 이미지 가져오기 pd_file
	    // ImageUploadHandler 클래스에서 setAttribute()로 넘겼으므로 getAttribute()로 처리
	    //String p_img1 = "/mvc_jsp_shopping/resources/upload/" + req.getAttribute("fileName");   // 파일명만 가져오기. 이게 이제 db로 들어가는것
	    // 이미지핸들러에서 만든 req.getAttribute("fileName") 가져오고 앞 경로는 우리가 설정해줌
		
		// 수정 START
	    String  p_img1 = "/basic_1team/resources/upload/" + file.getOriginalFilename();   // /세번째패키지명/upload경로/파일명(file.getOriginalFilename())   / 파일명만 가져오기. 이게 이제 db로 들어가는것
	      // dto.getPdImg() ==> /spring_pj_ict02/resources/upload/트롬세탁기.jpg
	      System.out.println("dto.review_img() ==>" + p_img1); //dto.getPdImg() ==>/spring_pj_ict02/resources/upload/아이폰12.png
	      // 수정 END
		
		
	    dto.setReview_img(p_img1);
		System.out.println("이미지 : " +p_img1);
		// 4단계. 싱글톤방식으로 DAO 객체 생성, 다형성 적용
		//ReviewDAO dao = ReviewDAOImpl.getInstance();
		
		// 5단계. 게시글 수정 처리 후 컨트롤러에서 list로 이동
		dao.writeReview(dto);
		
		// 6단계. jsp로 처리결과 전달
        //req.setAttribute("insertCnt", insertCnt);
		
	    	   } catch(IOException e) {
	 	    	  e.printStackTrace();
	 	      } finally {
	 	    	  if(fis != null) fis.close();
	 	    	  if(fos != null) fos.close();
	 	      }
	 	      

	 	   }
}
