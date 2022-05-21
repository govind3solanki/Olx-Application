package com.zensar.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductRowMapper<T> implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int line) throws SQLException {

		ProductResultSetExtractor extractor = new ProductResultSetExtractor();

		return extractor.extractData(rs);
	}

}
