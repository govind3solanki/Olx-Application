package com.zensar.spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	 private JdbcTemplate template;
	//private NamedParameterJdbcTemplate npjt;

	public ProductRepositoryImpl1() {

	}

	public int insertProduct(Product product) {
		// createTable();
		 String sql = "insert into product values(" + product.getProductId() + ",'" +
		 product.getProductName() + "',"
		 + product.getProductCost() + ");";
		/*
		 * String sql =
		 * "insert into product values(:productId,:productName,:productCost)";
		 * MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		 * mapSqlParameterSource.addValue("productId", product.getProductId());
		 * mapSqlParameterSource.addValue("productName", product.getProductName());
		 * mapSqlParameterSource.addValue("productCost", product.getProductCost());
		 */
		template.execute(sql);
		return 1;
	}

	/*
	 * public void createTable() { template.
	 * execute("create table product(productId int ,productName varchar(50),productCost int)"
	 * ); }
	 */

	
	  public JdbcTemplate getTemplate() { return template; }
	  public void setTemplate(JdbcTemplate template) { this.template = template;}
	 

	/*
	 * public List<Product> getAllProducts() { String sql= "select * from product";
	 * List<Product> product = template.query(sql,(rs, rowNum) ->new
	 * Product(rs.getInt("productId"),rs.getString("productName"),rs.getInt(
	 * "productCost"))); return product; }
	 */

	public List<Product> getAllProducts() {
		List<Product> product = template.query("SELECT * FROM product", new ProductRowMapper<Product>());
		return product;
	}

	public void updateProduct(int id, String productName, int productCost) {
		/*
		 * MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		 * mapSqlParameterSource.addValue("ProductName",productName);
		 */
		template.update("update product set productName = :productName where productId = :id",productName,id);
	}

	public void deleteProduct(int id) {
		String sql = "DELETE FROM product WHERE productId = ?";
		/*
		 * MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		 * mapSqlParameterSource.addValue("ProductName",id);
		 */
		template.update(sql,id);
	}

}
