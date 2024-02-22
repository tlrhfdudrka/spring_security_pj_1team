package spring.mvc.basic_1team.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.basic_1team.page.ad_Paging;
import spring.mvc.basic_1team.dao.Ad_product_DAO;
import spring.mvc.basic_1team.dto.Ad_product_DTO;

@Service
public class Ad_product_ServiceImpl implements Ad_product_Service {

	@Autowired
	private Ad_product_DAO dao;
	
	// 상품 목록
	@Override
	public void pdListAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdListAction");
		
		String pageNum = req.getParameter("pageNum");
		
		int total = dao.pdCnt();
		System.out.println("total : " + total);
		
		ad_Paging paging = new ad_Paging(pageNum);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
		
		List<Ad_product_DTO> list = dao.pdList(map);
		
		model.addAttribute("paging", paging);
		model.addAttribute("list", list);
	}
	
	// 상품 등록
    @Override
    public void pdInsertAction(MultipartHttpServletRequest req, HttpServletResponse res, Model model) 
            throws ServletException, IOException {
        
        System.out.println("ProductServiceImpl - productAddAction");
        
        List<MultipartFile> fileIn = new ArrayList<MultipartFile>();
        
        fileIn.add(req.getFile("pd_img1"));
        fileIn.add(req.getFile("pd_img2"));
        fileIn.add(req.getFile("pd_detail_img"));
        
        String saveDir = req.getSession().getServletContext().getRealPath("/resources/upload/");
        System.out.println("saveDir : " + saveDir);
        
        String realDir = "D:\\dev\\workspace-spring\\spring_security_pj_1team\\src\\main\\webapp\\resources\\upload\\";
        System.out.println("realDir" + realDir);

        for (MultipartFile file : fileIn) {
        	
            String originalFilename = file.getOriginalFilename();
            String savePath = saveDir + originalFilename;
            String realPath = realDir + originalFilename;

            file.transferTo(new File(savePath));

            FileInputStream fis = null;
            FileOutputStream fos = null;
            
            try {
            	
                fis = new FileInputStream(savePath);
                fos = new FileOutputStream(realPath);

                int data;
                
                while ((data = fis.read()) != -1) {
                	
                    fos.write(data);
                }
                
            } catch (IOException e) {
            	
                e.printStackTrace();
                
            } finally {
            	
                if (fis != null) {
                	
                    fis.close();
                }
                
                if (fos != null) {
                	
                    fos.close();
                }
            }
        }

        Ad_product_DTO dto = new Ad_product_DTO();
        
        dto.setPd_name(req.getParameter("pd_name"));
        dto.setPd_img1("/basic_1team/resources/upload/" + fileIn.get(0).getOriginalFilename());
        dto.setPd_img2("/basic_1team/resources/upload/" + fileIn.get(1).getOriginalFilename());
        dto.setPd_detail_img("/basic_1team/resources/upload/" + fileIn.get(2).getOriginalFilename());
        dto.setPd_price(Integer.parseInt(req.getParameter("pd_price")));
        dto.setPd_stuck(Integer.parseInt(req.getParameter("pd_stuck")));
        
        String p_category = req.getParameter("category_num");
        
        int category = 0;
        
        if ("Outer".equals(p_category)) {
        	
            category = 1;
            
        } else if ("Top".equals(p_category)) {
        	
            category = 2;
            
        } else if ("Bottom".equals(p_category)) {
        	
            category = 3;
        }
        
        dto.setCategory_num(category);
        dto.setPd_content(req.getParameter("pd_content"));

        int insertCnt = dao.pdInsert(dto);

        model.addAttribute("insertCnt", insertCnt);
    }
	
	// 상품 상세페이지
	@Override
	public void pdListDetailAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdListDetailAction");
		
		int pd_num = Integer.parseInt(req.getParameter("pd_num")); 
		int pageNum = Integer.parseInt(req.getParameter("pageNum")); 
				
		Ad_product_DTO dto = dao.pdListDetail(pd_num);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pd_num", pd_num);
		model.addAttribute("dto", dto);
	}

	// 상품 수정
	@Override
	public void pdUdateAction(MultipartHttpServletRequest req, HttpServletResponse res, Model model) 
	        throws ServletException, IOException {

	    System.out.println("Ad_product_ServiceImp - pdUdateAction");
	    
	    String hiddenPageNum = req.getParameter("hiddenPageNum");
	    int hiddenPdNum = Integer.parseInt(req.getParameter("hiddenPdNum"));
	    
	    String hiddenPdImg1 = req.getParameter("hiddenPdImg1");
	    String hiddenPdImg2 = req.getParameter("hiddenPdImg2");
	    String hiddenPdImgDe = req.getParameter("hiddenPdImgDe");
	    
	    List<MultipartFile> fileUp = new ArrayList<MultipartFile>();
	    
	    fileUp.add(req.getFile("pd_img1"));
	    fileUp.add(req.getFile("pd_img2"));
	    fileUp.add(req.getFile("pd_detail_img"));
	    
	    String saveDir = req.getSession().getServletContext().getRealPath("/resources/upload/");
	    System.out.println("saveDir : " + saveDir);
	    
	    String realDir = "D:\\dev\\workspace-spring\\spring_security_pj_1team\\src\\main\\webapp\\resources\\upload\\";
	    System.out.println("realDir" + realDir);

	    List<String> uploadedFilePaths = new ArrayList<>();

	    for (int i = 0; i < fileUp.size(); i++) {
	    	
	        MultipartFile file = fileUp.get(i);
	        
	        String originalFilename = file.getOriginalFilename();
	        
	        String savePath = saveDir + originalFilename;
	        String realPath = realDir + originalFilename;

	        if (file.isEmpty()) {
	        	
	            switch (i) {
	            
	                case 0:
	                    uploadedFilePaths.add(hiddenPdImg1);
	                    break;
	                    
	                case 1:
	                    uploadedFilePaths.add(hiddenPdImg2);
	                    break;
	                    
	                case 2:
	                    uploadedFilePaths.add(hiddenPdImgDe);
	                    break;
	            }
	            
	        } else {
	        	
	            file.transferTo(new File(savePath));
	            
	            FileInputStream fis = null;
	            FileOutputStream fos = null;
	            
	            try {
	            	
	                fis = new FileInputStream(savePath);
	                fos = new FileOutputStream(realPath);
	                
	                int data;
	                
	                while ((data = fis.read()) != -1) {
	                	
	                    fos.write(data);
	                }
	                
	                uploadedFilePaths.add("/basic_1team/resources/upload/" + originalFilename);
	                
	            } catch (IOException e) {
	            	
	                e.printStackTrace();
	                
	            } finally {
	            	
	                if (fis != null) {
	                	
	                    fis.close();
	                }
	                
	                if (fos != null) {
	                	
	                    fos.close();
	                }
	            }
	        }
	    }

	    Ad_product_DTO dto = new Ad_product_DTO();
	    dto.setPd_num(hiddenPdNum);
	    dto.setPd_name(req.getParameter("pd_name"));
	    dto.setPd_price(Integer.parseInt(req.getParameter("pd_price")));
	    dto.setPd_stuck(Integer.parseInt(req.getParameter("pd_stuck")));
	    
	    String p_category = req.getParameter("category_num");
	    int category = 0;
	    if ("Outer".equals(p_category)) {
	        category = 1;
	    } else if ("Top".equals(p_category)) {
	        category = 2;
	    } else if ("Bottom".equals(p_category)) {
	        category = 3;
	    }
	    dto.setCategory_num(category);
	    dto.setPd_content(req.getParameter("pd_content"));
	    dto.setPd_img1(uploadedFilePaths.get(0));
	    dto.setPd_img2(uploadedFilePaths.get(1));
	    dto.setPd_detail_img(uploadedFilePaths.get(2));
	  
	    int updateCnt = dao.pdUdate(dto);
	  
	    req.setAttribute("updateCnt", updateCnt);
	    req.setAttribute("hiddenPageNum", hiddenPageNum); 
	    req.setAttribute("hiddenPdNum", hiddenPdNum);
	}

	// 상품 삭제
	@Override
	public void pdDeleteAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		System.out.println("Ad_product_ServiceImp - pdDeleteAction");
		
		int pd_num = Integer.parseInt(req.getParameter("pd_num"));
		
		int deleteCnt = dao.pdDelete(pd_num);
		
		model.addAttribute("deleteCnt", deleteCnt);
	}
}
