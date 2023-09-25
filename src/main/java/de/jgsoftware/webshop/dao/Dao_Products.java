/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jgsoftware.webshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_products;
import de.jgsoftware.webshop.model.Product;
import de.jgsoftware.webshop.model.jpa.shopdb.Products;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_Products implements i_dao_products {
	@Autowired
	@Qualifier(value = "shopJdbcTemplate")
	JdbcTemplate jtm2;

	@Autowired
	@Qualifier(value = "defaultJdbcTemplate")
	JdbcTemplate jtm;

	public List<Products> productList;

	@Override
	public List<Products> getProductsforLandingpage() {

		/*
		 * manuel query over JDBC Tempalte edit form demodb to shopdb
		 */
		productList = jtm.query("select * from PRODUCTS where LANDINGPAGE like '1'",
				new BeanPropertyRowMapper(Product.class));

		// List<Products> productList = (List) jpashopprodcuts.allactiveprodcuts();
		return productList;
	}

	@Override
	public Products getProductById(long productId) {
		de.jgsoftware.webshop.model.jpa.shopdb.Products cartuserproduct = new de.jgsoftware.webshop.model.jpa.shopdb.Products();

		/*
		 * 
		 * manuel query over jtm jdbc template
		 */
		// select * from public.PRODUCT where product_id = 1;
		String sql = "select * from PRODUCTS where product_id = " + productId;
		cartuserproduct = (Products) jtm.queryForObject(sql, new BeanPropertyRowMapper(Product.class));

		// cartuserproduct = (Products) jpashopprodcuts.getselectedproduct();

		// jtm.query("select * from USERDETAIL where username like " + "'" + result +
		// "'", new BeanPropertyRowMapper(User.class));
		// List<Product> productList = jtm.query("select * from public.PRODUCT where
		// product_id =" + productId, new BeanPropertyRowMapper(Product.class));

		return cartuserproduct;
	}

	// textfield in webshop
	@Override
	public List<Products> searchProductovertextfield(String searchProduct, Pageable pageable) {
		productList = jtm2.query("select * from Products where productname like " + "'" + searchProduct + "'",
				new BeanPropertyRowMapper(Products.class));
		return productList;
	}

	// textfield in webshop with top 25
	@Override
	public List<Products> searchProductop25(String searchProduct) {
		productList = jtm2.query("select top(25) * from Products where productname like " + "'" + searchProduct + "'",
				new BeanPropertyRowMapper(Products.class));
		return productList;
	}

}
