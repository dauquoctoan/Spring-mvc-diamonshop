package DiamonShops.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dto.ProductsDto;
import DiamonShops.Entity.Categorys;
import DiamonShops.Entity.Menus;
import DiamonShops.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> GetDataSlide();
	@Autowired
	public List<Categorys> GetDataCategorys();
	@Autowired
	public List<Menus> GetDataMenus();
	@Autowired
	public List<ProductsDto> GetDataNewProducts();
	@Autowired
	public List<ProductsDto>GetDataHighlightProducts();
	@Autowired
	public List<ProductsDto>GetDataProducts(String id);
}
