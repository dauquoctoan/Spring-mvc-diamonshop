package DiamonShops.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShops.UserService.HomeServiceImpl;
import DiamonShops.UserService.ProductServiceImpl;

@Controller
public class ProductController extends BaseController{
	@Autowired
	ProductServiceImpl productService;
	@Autowired
	HomeServiceImpl homeServiceImpl;
	@RequestMapping(value = "/product-detail/{id}")
	public ModelAndView ProductDetail(@PathVariable String id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", productService.GetDataProductById(id));
		_mvShare.addObject("categorys", homeServiceImpl.GetDataCategorys());
		int idcategory= productService.GetDataProductById(id).getId_category();
		_mvShare.addObject("products", productService.GetDataProductByIdCategory(idcategory));
		return _mvShare;
	}
}
