package spring.mvc.basic_1team.dao;

import java.util.List;
import java.util.Map;

import spring.mvc.basic_1team.dto.Us_product_DTO;

public interface Us_product_DAO {

	public int usCnt(int category_num);
	public List<Us_product_DTO> usListAction(Map<String, Object> map);
	public Us_product_DTO udDetailList(int pd_num);
}
