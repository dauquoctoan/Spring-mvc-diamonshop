package DiamonShops.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dto.PaginatesDto;

@Service
public interface IPaginatesService {
	@Autowired
	public PaginatesDto getInforPaginates(int totalData, int limit, int currentPage);
}
