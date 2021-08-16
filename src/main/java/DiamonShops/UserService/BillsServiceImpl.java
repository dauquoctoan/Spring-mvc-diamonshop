package DiamonShops.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShops.Dao.BillsDao;
import DiamonShops.Dto.CartDto;
import DiamonShops.Entity.BillDetail;
import DiamonShops.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService{
	@Autowired
	public BillsDao billsDao;
	
	
	public int AddBills(Bills bill) {
		return billsDao.AddBills(bill);
	}

	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		long  idBills = billsDao.getIdLastBills();
		for(Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());		
			long dem = billsDao.AddbillsDetail(billDetail);
		}
	}

}
