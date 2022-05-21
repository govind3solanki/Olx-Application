package com.zensar.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import com.zensar.spring.beans.Product;

public class ProductResultSetExtractor implements ResultSetExtractor<Object> {

    @Override
    public Object extractData(ResultSet rs) throws SQLException {
    	Product product = new Product();
    	product.setProductId(rs.getInt(1));
    	product.setProductName(rs.getString(2));
    	product.setProductCost(rs.getInt(3));
        return product;
    }
}
