package com.zensar.spring.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zensar.spring.beans.Product;

public class ProductRepositoryImpl1 implements ProductRepository {

	private JdbcTemplate template;

	public ProductRepositoryImpl1() {

	}

	public int insertProduct(Product product) {
		createTable();
		String sql = "insert into product values(" + product.getProductId() + ",'" + product.getProductName() + "',"
				+ product.getProductCost() + ");";
		template.execute(sql);
		return 1;
	}

	public void createTable() {
		template.execute("create table product(productId int ,productName varchar(50),productCost int)");
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Product> getAllProducts() {
		String sql= "select * from product";
		List<Product> product = template.query(sql,(rs, rowNum) ->new Product(rs.getInt("productId"),rs.getString("productName"),rs.getInt("productCost")));
        return product;
	}

	public void updateProduct(int id,String productName,int productCost) {
		template.update("update product set productName = ? where productId = ?",productName,id);
	}

	public void deleteProduct(int id) {
		String sql = "DELETE FROM product WHERE productId = ?";
	         template.update(sql,id);
	}

}
