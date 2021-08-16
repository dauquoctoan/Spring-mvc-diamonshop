package DiamonShops.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dao.CategorysDao;
import DiamonShops.Dao.MenusDao;
import DiamonShops.Dao.ProductsDao;
import DiamonShops.Dao.SlidesDao;
import DiamonShops.Dto.ProductsDto;
import DiamonShops.Entity.Categorys;
import DiamonShops.Entity.Menus;
import DiamonShops.Entity.Slides;
@Service
public class HomeServiceImpl implements IHomeService{
	@Autowired
	private SlidesDao slideDao;
	@Autowired
	private CategorysDao categoryDao;
	@Autowired
	private MenusDao menusDao;
	@Autowired
	private ProductsDao productDto;
	
	public List<Slides> GetDataSlide() {
		return slideDao.GetDataSlide();
	}

	public List<Categorys> GetDataCategorys() {
		return categoryDao.GetDataCategory();
	}

	public List<Menus> GetDataMenus() {
		return menusDao.GetDataMenus();
	}

	public List<ProductsDto> GetDataNewProducts() {
		return productDto.GetDataNewProducts();
	}

	public List<ProductsDto> GetDataHighlightProducts() {
		return productDto.GetDataHighlightProducts();
	}

	public List<ProductsDto> GetDataProducts(String id) {
		return productDto.GetDataProducts(id);
	}
}
