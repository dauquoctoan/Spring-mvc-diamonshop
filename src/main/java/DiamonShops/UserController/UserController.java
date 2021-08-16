package DiamonShops.UserController;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DiamonShops.Entity.Users;
import DiamonShops.UserService.AccountServiceImpl;

@Controller
public class UserController extends BaseController{
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	public ModelAndView Registers(){
		_mvShare.setViewName("user/account/register");
		_mvShare.addObject("users", new Users());
		return _mvShare;
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("users") Users user){
		List<Users> userCheck = new ArrayList<Users>();
		userCheck = accountService.getUserByName(user.getUser());
		if(userCheck.size() == 1) {
			_mvShare.addObject("status", "Tên tài khoản đã tồn tại!, vui lòng chọn tên khác");
		}
		else {
			int count = accountService.AddAccount(user);
			if(count > 0) {
				_mvShare.addObject("status", "dang ky tai khoan thanh cong");
			}
			else {
				_mvShare.addObject("status", "dang ky tai khoan that bai");
			}
		}
		_mvShare.setViewName("user/account/register");
		return _mvShare;
	}
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session,@ModelAttribute("users") Users user_check){
		List<Users> userCheck = new ArrayList<Users>();
		userCheck = accountService.getUserByName(user_check.getUser());
		if(userCheck.size() == 1) {
			Users user = accountService.CheckAccount(user_check);
			if(user != null) {
				session.setAttribute("user", user);
				_mvShare.setViewName("redirect:/trang-chu");
			}else {
				_mvShare.addObject("loginStatus", "Sai mat khau");
				_mvShare.setViewName("user/account/register");
			}
		}else {
			_mvShare.addObject("loginStatus", "tai khoan khong ton tai");
			_mvShare.setViewName("user/account/register");
		}
		return _mvShare;
	}
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String LogOut(HttpSession session,@ModelAttribute("users") Users user_check){
		session.removeAttribute("user");
		session.removeAttribute("Cart");
		session.removeAttribute("TotalPriceCart");
		session.removeAttribute("TotalQuantyCart");
		return "redirect:/trang-chu";
	}
}
