package DiamonShops.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dao.ProductsDao;
import DiamonShops.Dto.ProductsDto;
@Service
public class CategoryServiceImpl implements  ICategorysService{
	@Autowired
	public ProductsDao productsDao;

	public List<ProductsDto> GetDataProductPaginate(String id, int start, int limit) {
		return productsDao.GetDataProductsPaginate(id, start, limit);
	}

	public List<ProductsDto> GetAllDataProduct(String id) {
		return productsDao.GetDataProducts(id);
	}

}
