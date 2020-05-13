package de.jgsoftware.webshop.dao;

import de.jgsoftware.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DaoProduct
{

    @Autowired
    private JdbcTemplate jtm;


    public List<Product> getProductsforLandingpage()
    {


        List<Product> productList = jtm.query("select * from public.PRODUCT where LANDINGPAGE like '1'", new BeanPropertyRowMapper(Product.class));

        return productList;
    }

}
