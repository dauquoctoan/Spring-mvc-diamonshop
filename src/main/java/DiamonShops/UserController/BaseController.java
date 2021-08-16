package DiamonShops.UserController;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import DiamonShops.UserService.HomeServiceImpl;

@Controller
public class BaseController {
	@Autowired
	public HomeServiceImpl _homeServiceImpl;
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Base() {
		_mvShare.addObject("menus", _homeServiceImpl.GetDataMenus());
		return _mvShare;
	}
}
