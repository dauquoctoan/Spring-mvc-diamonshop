package DiamonShops.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShops.Entity.Categorys;
import DiamonShops.Entity.MapperCategorys;
@Repository
public class CategorysDao extends BaseDao{

	public List<Categorys> GetDataCategory(){
		List<Categorys>  list = new ArrayList<Categorys>();
		String sql = "SELECT * FROM categorys";
		list = _jdbcTemplates.query(sql, new MapperCategorys());
		return list;
	}
}
