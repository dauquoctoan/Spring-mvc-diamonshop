package DiamonShops.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import DiamonShops.Dto.MapperProductDto;
import DiamonShops.Dto.ProductsDto;
@Repository
public class ProductsDao extends BaseDao{
	public final boolean yes = true;
	public final boolean no = false;
	
	private StringBuffer  sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id AS id_product ");
		sql.append(", p.id_category ");
		sql.append(",p.sizes ");
		sql.append(",p.name ");
		sql.append(",p.price ");
		sql.append(" ,p.sale ");
		sql.append(",p.title ");
		sql.append(",p.highlight ");
		sql.append(",p.new_product ");
		sql.append(",p.details ");
		sql.append(",c.id AS id_color ");
		sql.append(",c.name AS name_color ");
		sql.append(",c.code AS code_color ");
		sql.append(",c.img ");
		sql.append(",p.created_at ");
		sql.append(",p.updated_at ");
		sql.append("FROM products as p ");
		sql.append("INNER JOIN ");
		sql.append("colors AS c ");
		sql.append("ON p.id = c.id_product ");
		return sql;
	}
	
	private String  sqlGetproduct(boolean newproduct, boolean hilight) {
		StringBuffer sql = sqlString();
		if(hilight) {
			sql.append("WHERE p.highlight = true ");
		}if(newproduct) {
			sql.append("WHERE p.new_product = true ");
		}
		
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		
		if(hilight) {
			sql.append("LIMIT 18;");
		}if(newproduct) {
			sql.append("LIMIT 8;");
		}
		return sql.toString();
	}
	private String  sqlGetproducts(String id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE p.id_category = "+ id +" ");
		sql.append("GROUP BY p.id, c.id_product ");
		return sql.toString();
	}
	
	private String  sqlGetproductsPaginate(String id, int start, int limit) {
		StringBuffer sql = sqlString();
		sql.append("WHERE p.id_category = "+ id +" ");	
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("LIMIT "+start+", "+limit+";");
		return sql.toString();
	}
	private String  sqlGetproductsById(String id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE p.id = "+ id +" ");	
		sql.append("GROUP BY p.id, c.id_product;");
		return sql.toString();
	}
	private String  sqlGetproductsByIdCategorys(int id) {
		StringBuffer sql = sqlString();
		sql.append("WHERE p.id_category = "+ id +" ");	
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		sql.append("LIMIT 6;");
		return sql.toString();
	}
	
	
	public List<ProductsDto> GetDataNewProducts(){
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql= sqlGetproduct(yes, no);
		list = _jdbcTemplates.query(sql, new MapperProductDto());
		return list;
	}
	public List<ProductsDto> GetDataHighlightProducts(){
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql= sqlGetproduct(no, yes);
		list = _jdbcTemplates.query(sql, new MapperProductDto());
		return list;
	}
	
	public List<ProductsDto> GetDataProducts(String id){
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql= sqlGetproducts(id);
		list = _jdbcTemplates.query(sql, new MapperProductDto());
		return list;
	}
	public List<ProductsDto> GetDataProductsPaginate(String id, int start, int limit){
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		if(GetDataProducts(id).size()>0) {
			String sql= sqlGetproductsPaginate(id, start, limit);
			list = _jdbcTemplates.query(sql, new MapperProductDto());
		}
		return list;
	}
	
	public ProductsDto GetDataProductsById(String id){
		String sql= sqlGetproductsById(id);
		ProductsDto product = _jdbcTemplates.queryForObject(sql, new MapperProductDto());
		return product;
	}
	
	public List<ProductsDto> GetDataProductByIdCategory(int id){
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		String sql= sqlGetproductsByIdCategorys(id);
		list  = _jdbcTemplates.query(sql, new MapperProductDto());
		return list;
	}
}
