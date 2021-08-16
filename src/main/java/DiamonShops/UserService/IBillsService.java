package DiamonShops.UserService;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import DiamonShops.Dto.CartDto;
import DiamonShops.Entity.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);
	
	public void AddBillsDetail(HashMap<Long, CartDto> carts);
}
