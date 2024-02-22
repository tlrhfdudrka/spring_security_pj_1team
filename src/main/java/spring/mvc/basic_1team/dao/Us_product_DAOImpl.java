package spring.mvc.basic_1team.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.Us_product_DTO;

@Repository
public class Us_product_DAOImpl implements Us_product_DAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int usCnt(int category_num) {
		
		int total = sqlSession.selectOne("spring.mvc.basic_1team.dao.Us_product_DAO.usCnt", category_num);
		
		return total;
	}
	
	@Override
	public List<Us_product_DTO> usListAction(Map<String, Object> map) {
		
		System.out.println("Us_product_DAOImpl - usList");
		
		List<Us_product_DTO> list = sqlSession.selectList("spring.mvc.basic_1team.dao.Us_product_DAO.usListAction", map);
		
		return list;
	}

	@Override
	public Us_product_DTO udDetailList(int pd_num) {
		
		System.out.println("Us_product_DAOImpl - udDetailList");
		
		Us_product_DTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.Us_product_DAO.usListAction", pd_num);
		
		return dto;
    }
}
