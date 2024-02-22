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

import spring.mvc.basic_1team.dao.CartDAO;
import spring.mvc.basic_1team.dto.CartDTO;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDAO dao;
	
	// 장바구니 목록
	@Override
	public void cartPdListAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdListAction(req, res) >>");
		
//		String s_user_id = (String)req.getSession().getAttribute("sessionID");
//		System.out.println("s_user_id : " + s_user_id);

		List<CartDTO> list = dao.cartList("aa");
		
//		int totalPrice = dao.cartTotalPrice(s_user_id);
//		int selectpdPrice = dao.cartSelectpdPrice(s_user_id);
		
		
		
		model.addAttribute("list", list);
//		model.addAttribute("totalPrice", totalPrice);
//		model.addAttribute("selectpdPrice", selectpdPrice);
		
	}

	// 장바구니 상품 삭제
	@Override
	public void cartPdDeleteAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdDeleteAction(req, res) >>");
		
		int hidden_cart_num =  Integer.parseInt(req.getParameter("hidden_cart_num"));
		
		dao.cartPdDelete(hidden_cart_num);
		
	}

	// 장바구니 상품 수정(수량)
	@Override
	public void cartPdUpdateAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdUpdateAction(req, res) >>");
		
		int hidden_cart_num = Integer.parseInt(req.getParameter("hidden_cart_num"));
		int cart_cnt = Integer.parseInt(req.getParameter("cart_cnt"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("hidden_cart_num", hidden_cart_num);
		map.put("cart_cnt", cart_cnt);
		
		dao.cartUpdate(map);
		
	}

	// 장바구니 상품 체크박스 선택시 
	@Override
	public void cartPdCheckedAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdCheckedAction(req, res) >>");
		
		int hidden_cart_num = Integer.parseInt(req.getParameter("hidden_cart_num"));
		
		dao.cartPdchecked(hidden_cart_num);
		
	}

	//장바구니 상품 체크박스 비선택시
	@Override
	public void cartPdNotCheckedAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdNotCheckedAction(req, res) >>");
		
		int hidden_cart_num = Integer.parseInt(req.getParameter("hidden_cart_num"));
		
		dao.cartPdNotcheked(hidden_cart_num);
	}

	// 장바구니 상품 추가시 중복확인(bottom)
	@Override
	public void cart_pdchk_bottom(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cart_pdchk_bottom(req, res) >>");
		
		String s_user_id = (String)req.getSession().getAttribute("sessionID");
		int pd_num = Integer.parseInt(req.getParameter("pd_num")); // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		System.out.println("pd_num : " + pd_num);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("s_user_id", s_user_id);
		map.put("pd_num", pd_num);	
		
		int selectCnt = dao.cart_pdchk(map);
		
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("pd_num", pd_num);
		
	}
	
	// 장바구니 상품 추가시 중복확인(outer)
	@Override
	public void cart_pdchk_outer(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cart_pdchk_outer(req, res) >>");
		
		String s_user_id = (String)req.getSession().getAttribute("sessionID");
		int pd_num = Integer.parseInt(req.getParameter("pd_num")); // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("s_user_id", s_user_id);
		map.put("pd_num", pd_num);	
		
		int selectCnt = dao.cart_pdchk(map);
		
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("pd_num", pd_num);
	}

	// 장바구니 상품 추가시 중복확인(top)
	@Override
	public void cart_pdchk_top(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cart_pdchk_top(req, res) >>");
		
		String s_user_id = (String)req.getSession().getAttribute("sessionID");
		
		int pd_num = Integer.parseInt(req.getParameter("pd_num")); // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("s_user_id", s_user_id);
		map.put("pd_num", pd_num);	
		
		int selectCnt = dao.cart_pdchk(map);
		
		model.addAttribute("selectCnt", selectCnt);
		model.addAttribute("pd_num", pd_num);
	}
	
	//  장바구니에 상품 추가 처리페이지
	@Override
	public void cartPdAddAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - cartPdAddAction(req, res) >>");
		
		String s_user_id = (String)req.getSession().getAttribute("sessionID");
		
		int pd_num = Integer.parseInt(req.getParameter("pd_num")); // getparameter로  상품상세페이지에서 받은 값 가져올 것 
		
		CartDTO dto = new CartDTO();
		
		dto.setUser_id(s_user_id);
		dto.setPd_num(pd_num);
		
		
		int insertCnt = dao.cartPdAdd(dto);
		
		model.addAttribute("insertCnt", insertCnt);
		
	}

	
	
}
