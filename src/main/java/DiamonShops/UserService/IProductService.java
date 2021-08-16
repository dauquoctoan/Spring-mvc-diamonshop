package DiamonShops.UserService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dto.ProductsDto;

@Service
public interface IProductService {
	@Autowired
	public ProductsDto GetDataProductById(String id);
	@Autowired
	public List<ProductsDto> GetDataProductByIdCategory(int id);
}
