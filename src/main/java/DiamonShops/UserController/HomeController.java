package DiamonShops.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {

	@RequestMapping(value = { "/", "/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeServiceImpl.GetDataSlide());
		_mvShare.addObject("categorys", _homeServiceImpl.GetDataCategorys());
		_mvShare.addObject("newproduct", _homeServiceImpl.GetDataNewProducts());
		_mvShare.addObject("highlight", _homeServiceImpl.GetDataHighlightProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}

}
