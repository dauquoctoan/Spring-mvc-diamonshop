package DiamonShops.Dao;

import org.springframework.stereotype.Repository;

import DiamonShops.Entity.BillDetail;
import DiamonShops.Entity.Bills;

@Repository
public class BillsDao extends BaseDao{
	public int AddBills(Bills bill) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO bills ");
		sql.append("( ");
		sql.append("    `user`, ");
		sql.append("    `phone`, ");
		sql.append("    `display_name`, ");
		sql.append("    `address`, ");
		sql.append("    `total`, ");
		sql.append("    `quanty`, ");
		sql.append("    `note` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    '"+bill.getUser()+"', ");
		sql.append("    '"+bill.getPhone()+"', ");
		sql.append("    '"+bill.getDisplay_name()+"', ");
		sql.append("    '"+bill.getAddress()+"', ");
		sql.append("    "+bill.getTotal()+", ");
		sql.append("    "+bill.getQuanty()+", ");
		sql.append("    '"+bill.getNote()+"' ");
		sql.append(")");
		int insert = _jdbcTemplates.update(sql.toString());
		return insert;
	}
	public long  getIdLastBills() {
		StringBuffer sql =  new StringBuffer();
		sql.append("SELECT MAX(id) FROM bills");
		long id = _jdbcTemplates.queryForObject(sql.toString(), new Object[] {}, long.class);
		return id;
	}
	
	public int AddbillsDetail(BillDetail billDetail) {
		StringBuffer  sql = new StringBuffer();
		sql.append("INSERT INTO `billdetail` ");
		sql.append("( ");
		sql.append("    `id_product`, ");
		sql.append("    `id_bills`, ");
		sql.append("    `quanty`, ");
		sql.append("    `total` ");
		sql.append(") ");
		sql.append("VALUES ");
		sql.append("( ");
		sql.append("    "+billDetail.getId_product()+", ");
		sql.append("    "+billDetail.getId_bills()+", ");
		sql.append("    "+billDetail.getQuanty()+", ");
		sql.append("    "+billDetail.getTotal()+" ");
		sql.append(")");
		int insert = _jdbcTemplates.update(sql.toString());
		return insert;
	}
}
