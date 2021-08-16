package DiamonShops.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShops.Entity.MapperUsers;
import DiamonShops.Entity.Users;

@Repository
public class UsersDao extends BaseDao{
		public int AddAccount(Users user) {
			StringBuffer  sql = new StringBuffer();
			sql.append("INSERT ");
			sql.append("INTO users ");
			sql.append("( ");
			sql.append("    user, ");
			sql.append("    password, ");
			sql.append("    display_name, ");
			sql.append("    address ");
			sql.append(") ");
			sql.append("VALUES ");
			sql.append("( ");
			sql.append("   '"+user.getUser()+"', ");
			sql.append("   '"+user.getPassword()+"', ");
			sql.append("   '"+user.getDisplay_name()+"', ");
			sql.append("   '"+user.getAddress()+"' ");
			sql.append(")");
			int insert =_jdbcTemplates.update(sql.toString());
			return insert;
		}
		
		public List<Users> getUserById(String name) {
			List<Users> user = new ArrayList<Users>();
			String sql = "SELECT * FROM users WHERE user = '" + name+"'";
			user = _jdbcTemplates.query(sql, new MapperUsers());
			return user;
		}
		
		public Users CheckAccount(Users user) {
			String sql="SELECT * FROM users WHERE user = '" + user.getUser()+"'";
			Users result = _jdbcTemplates.queryForObject(sql, new MapperUsers());
			return result;
		}
}
