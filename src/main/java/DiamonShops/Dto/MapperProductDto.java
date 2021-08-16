package DiamonShops.Dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperProductDto implements RowMapper<ProductsDto>{

	public ProductsDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductsDto product = new ProductsDto();
		product.setId_product(rs.getLong("id_product"));
		product.setId_category(rs.getInt("id_category"));
		product.setSizes(rs.getString("sizes"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getDouble("price"));
		product.setSale(rs.getInt("sale"));
		product.setTitle(rs.getString("title"));
		product.setHighlight(rs.getBoolean("highlight"));
		product.setNew_product(rs.getBoolean("highlight"));
		product.setDetails(rs.getString("details"));
		product.setId_color(rs.getLong("id_color"));
		product.setName_color(rs.getString("name_color"));
		product.setCode_color(rs.getString("code_color"));
		product.setImg(rs.getString("img"));
		product.setCreated_at(rs.getDate("created_at"));
		product.setUpdated_at(rs.getDate("updated_at"));
		return product;
	}

}
