package DiamonShops.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShops.Entity.MapperMenus;
import DiamonShops.Entity.Menus;

@Repository
public class MenusDao extends BaseDao{	
	public List<Menus> GetDataMenus(){
		List<Menus> list = new ArrayList<Menus>();
		list = _jdbcTemplates.query("SELECT * FROM menus", new MapperMenus());
		return list;
	}
	
}
