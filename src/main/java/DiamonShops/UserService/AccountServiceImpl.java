package DiamonShops.UserService;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dao.UsersDao;
import DiamonShops.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	UsersDao usersDao = new UsersDao();
		
	public int AddAccount(Users user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
		return usersDao.AddAccount(user);
	}

	public List<Users> getUserByName(String name) {
		return usersDao.getUserById(name);
	}

	public Users CheckAccount(Users user) {
		String password = user.getPassword();
		
		user = usersDao.CheckAccount(user);
		if(user!=null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				return user;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

}
