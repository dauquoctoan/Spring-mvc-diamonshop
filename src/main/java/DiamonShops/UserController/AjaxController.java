package DiamonShops.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import DiamonShops.Dto.CartDto;
import DiamonShops.UserService.CartServiceImpl;

@Controller
public class AjaxController extends BaseController{
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	
	@RequestMapping(value="/addcart", method = RequestMethod.GET)
	@ResponseBody
	public String AddCart(HttpServletRequest request, HttpSession session, @RequestParam long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		int quanty =cartService.TotalQuanty(cart);
		 double tongtien = cartService.TotalPrice(cart);
		return "" + quanty + "|" + tongtien;
	}
}
