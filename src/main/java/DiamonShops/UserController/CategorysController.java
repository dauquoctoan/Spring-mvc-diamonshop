package DiamonShops.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import DiamonShops.Dto.PaginatesDto;
import DiamonShops.UserService.CategoryServiceImpl;
import DiamonShops.UserService.PaginatesServiceImpl;
@Controller
public class CategorysController extends BaseController{
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@Autowired
	private PaginatesServiceImpl paginatesServiceImpl;
	private int limit = 9;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		int Total =categoryServiceImpl.GetAllDataProduct(id).size();
		PaginatesDto paginatesDto = paginatesServiceImpl.getInforPaginates(Total, limit, 1);
		_mvShare.addObject("paginateInfor", paginatesDto);
		_mvShare.addObject("id", id);
		_mvShare.addObject("product", categoryServiceImpl.GetDataProductPaginate(id, paginatesDto.getStart(), paginatesDto.getEnd()));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{page}")
	public ModelAndView ProductPaginate(@PathVariable String id, @PathVariable String page) {
		_mvShare.setViewName("user/products/category");
		int Total =categoryServiceImpl.GetAllDataProduct(id).size();
		PaginatesDto paginatesDto = paginatesServiceImpl.getInforPaginates(Total, limit, Integer.parseInt(page));
		_mvShare.addObject("paginateInfor", paginatesDto);
		_mvShare.addObject("id", id);
		_mvShare.addObject("page", page);
		_mvShare.addObject("product", categoryServiceImpl.GetDataProductPaginate(id, paginatesDto.getStart(), paginatesDto.getLimit()));
		return _mvShare;
	}

	
}
