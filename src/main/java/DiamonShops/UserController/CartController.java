package DiamonShops.UserController;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import DiamonShops.Dto.CartDto;
import DiamonShops.Entity.Bills;
import DiamonShops.Entity.Users;
import DiamonShops.UserService.AccountServiceImpl;
import DiamonShops.UserService.BillsServiceImpl;
import DiamonShops.UserService.CartServiceImpl;

@Controller
public class CartController extends BaseController{
	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();
	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();
		
	@RequestMapping(value="/ToCart")
	public String ToCart() {
		return "user/cart/listcarts";
	}
	
	@RequestMapping(value="edit-cart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request, HttpSession session,  @PathVariable long id,  @PathVariable int quanty) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	@RequestMapping(value="/delete-cart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session,  @PathVariable long id) {
		HashMap<Long, CartDto> cart = (HashMap<Long, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Long, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
//		Users userInfor = (Users)session.getAttribute("user");
//		if(userInfor != null) {
//			bills.setAddress(userInfor.getAddress());
//			bills.setDisplay_name(userInfor.getAddress());
//			bills.setUser(userInfor.getAddress());
//		}
		_mvShare.addObject("bills", bills);
		return _mvShare;
	}
	@RequestMapping(value="checkout", method = RequestMethod.POST)
	public String CheckOutBills(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bill) {
		bill.setQuanty((Integer)session.getAttribute("TotalQuantyCart"));
		bill.setTotal((Double)session.getAttribute("TotalPriceCart"));
		if(billsService.AddBills(bill)>0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>)session.getAttribute("Cart");
			billsService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		session.removeAttribute("TotalPriceCart");
		session.removeAttribute("TotalQuantyCart");
		return "redirect:/trang-chu";
	}
}
