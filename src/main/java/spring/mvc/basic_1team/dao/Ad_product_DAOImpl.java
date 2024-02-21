package spring.mvc.basic_1team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.Ad_product_DTO;

@Repository
public class Ad_product_DAOImpl implements Ad_product_DAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int pdCnt() {
		
		System.out.println("Ad_product_DAOImpl - pdCnt");
		
		int total = sqlSession.selectOne("spring.mvc.basic_1team.dao.Ad_product_DAO.pdCnt");
		
		return total;
	}

	@Override
	public List<Ad_product_DTO> pdList(Map<String, Object> map) {
		
		System.out.println("Ad_product_DAOImpl - productList");
		
		List<Ad_product_DTO> list = sqlSession.selectList("spring.mvc.basic_1team.dao.Ad_product_DAO.pdList", map);
		
		return list;
	}
	
	@Override
	public int pdInsert(Ad_product_DTO dto) {
		
		System.out.println("Ad_product_DAOImpl - pdInsert");
		
		int insertCnt = sqlSession.insert("spring.mvc.basic_1team.dao.Ad_product_DAO.pdInsert", dto);
		
		return insertCnt;
	}

	@Override
	public Ad_product_DTO pdListDetail(int pd_num) {
		
		System.out.println("Ad_product_DAOImpl - pdListDetail");
		
		Ad_product_DTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.Ad_product_DAO.pdListDetail", pd_num);
		
		return dto;
	}

	@Override
	public int pdUdate(Ad_product_DTO dto) {
		
		System.out.println("Ad_product_DAOImpl - pdUdate");
		
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.Ad_product_DAO.pdUdate", dto);
		
		return updateCnt;
	}

	@Override
	public int pdDelete(int pd_num) {
		
		int deleteCnt = sqlSession.delete("spring.mvc.basic_1team.dao.Ad_product_DAO.pdDelete", pd_num);
		
		return deleteCnt;
	}
}
