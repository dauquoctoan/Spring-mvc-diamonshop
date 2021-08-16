package DiamonShops.UserService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dao.ProductsDao;
import DiamonShops.Dto.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	public ProductsDao productDao;

	public ProductsDto GetDataProductById(String id) {
		return productDao.GetDataProductsById(id);
	}

	public List<ProductsDto> GetDataProductByIdCategory(int id) {
		return productDao.GetDataProductByIdCategory(id);
	}
}
