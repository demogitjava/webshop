/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.jgsoftware.webshop.dao;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_products;
import de.jgsoftware.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import de.jgsoftware.webshop.dao.interfaces.demodb.i_jpa_useragent;
import de.jgsoftware.webshop.dao.interfaces.shop.i_jpa_products;
import de.jgsoftware.webshop.model.jpa.shopdb.Products;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_Products implements i_dao_products
{
    @Autowired
    @Qualifier(value = "shopJdbcTemplate")
    private JdbcTemplate jtm;


    public List<Product> productList;

    i_jpa_products jpashopprodcuts;
    

    @Override
    public List<Products> getProductsforLandingpage()
    {

        /*
            manuel query over
            JDBC Tempalte 
            edit form demodb to shopdb
        */
        //productList = jtm.query("select * from PRODUCTS where LANDINGPAGE like '1'", new BeanPropertyRowMapper(Product.class));

        List<Products> productList = (List) jpashopprodcuts.allactiveprodcuts();
        return productList;
    }



    @Override
    public Products getProductById(long productId)
    {
        de.jgsoftware.webshop.model.Product cartuserproduct = new de.jgsoftware.webshop.model.Product();



        // select * from public.PRODUCT where product_id = 1;
        String sql = "select * from PRODUCTS where product_id = " + productId;
        cartuserproduct = (Products) jtm.queryForObject(sql, new BeanPropertyRowMapper(Product.class));


        // jtm.query("select * from USERDETAIL where username like " + "'" + result + "'", new BeanPropertyRowMapper(User.class));
        //List<Product> productList = jtm.query("select * from public.PRODUCT where product_id =" + productId, new BeanPropertyRowMapper(Product.class));

        return cartuserproduct;
    }


    // textfield in webshop
    @Override
    public List<Product> searchProductovertextfield(String searchProduct, Pageable pageable)
    {
        productList = jtm.query("select * from Products where productname like " + "'" + searchProduct + "'", new BeanPropertyRowMapper(Product.class));
        return productList;
    }


    // textfield in webshop with top 25
    @Override
    public List<Product> searchProductop25(String searchProduct)
    {
        productList = jtm.query("select top(25) * from Products where productname like " + "'" + searchProduct + "'", new BeanPropertyRowMapper(Product.class));
        return productList;
    }

}
