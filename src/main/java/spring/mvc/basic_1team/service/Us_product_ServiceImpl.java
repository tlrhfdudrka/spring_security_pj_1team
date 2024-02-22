package spring.mvc.basic_1team.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.basic_1team.page.us_Paging;
import spring.mvc.basic_1team.dao.Us_product_DAO;
import spring.mvc.basic_1team.dto.Us_product_DTO;

@Service
public class Us_product_ServiceImpl implements Us_product_Service {

	@Autowired
	private Us_product_DAO dao;
	
	@Override
	public void usListAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		System.out.println("Us_product_ServiceImpl - usListAction");
		
		String pageNum = req.getParameter("pageNum");
		String category_num = req.getParameter("category_num"); 
		
	    int category = 0;
	    
	    if ("1".equals(category_num)) {
	    	
	        category = 1;
	        
	    } else if ("2".equals(category_num)) {
	    	
	        category = 2;
	        
	    } else if ("3".equals(category_num)) {
	    	
	        category = 3;
	    }
		
		System.out.println("category : " + category);
		
	    int total = dao.usCnt(category);
	    System.out.println("total : " + total);
	    
	    us_Paging us_Paging2 = new us_Paging(pageNum);
	    System.out.println("pageNum : " + us_Paging2.getPageNum());
	    
	    us_Paging2.setTotalCount(total);
	    
	    int start = us_Paging2.getStartRow();
		int end = us_Paging2.getEndRow();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("start", start);
		map.put("end", end);
	    
	    List<Us_product_DTO> list = dao.usListAction(map);
	    
	    model.addAttribute("paging2", us_Paging2);
	    model.addAttribute("list", list);
	}

	@Override
	public void usListDetailAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		System.out.println("Us_product_ServiceImpl - usListDetailAction");
		
		int pd_num = Integer.parseInt(req.getParameter("pd_num"));  
		int pageNum = Integer.parseInt(req.getParameter("pageNum")); 
		
		Us_product_DTO dto = dao.udDetailList(pd_num);
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pd_num", pd_num);
		model.addAttribute("dto", dto);
	}
}
