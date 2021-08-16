package DiamonShops.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Entity.Users;

@Service
public interface IAccountService {
	@Autowired
	public List<Users> getUserByName(String name);
	public int AddAccount(Users user);
	public Users CheckAccount(Users user);
}
