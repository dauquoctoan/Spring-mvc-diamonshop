package DiamonShops.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dto.ProductsDto;

@Service
public interface ICategorysService {
	@Autowired
	public List<ProductsDto> GetDataProductPaginate(String id,int start, int limit);
	@Autowired
	public List<ProductsDto> GetAllDataProduct(String id);
}
