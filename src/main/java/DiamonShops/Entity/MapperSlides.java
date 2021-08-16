package DiamonShops.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperSlides implements RowMapper<Slides>{

	public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
		Slides slide = new Slides();
		slide.setId(rs.getInt("id"));
		slide.setImg(rs.getString("img"));
		slide.setCaption(rs.getString("caption"));
		slide.setContent(rs.getString("content"));
		return slide;
	}
}
