package de.jgsoftware.webshop.dao;

import de.jgsoftware.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


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



    public Product getProductById(long productId)
    {
        de.jgsoftware.webshop.model.Product cartuserproduct = new de.jgsoftware.webshop.model.Product();



        // select * from public.PRODUCT where product_id = 1;
        String sql = "select * from public.PRODUCT where product_id = " + productId;
        cartuserproduct = (Product) jtm.queryForObject(sql, new BeanPropertyRowMapper(Product.class));


        // jtm.query("select * from USERDETAIL where username like " + "'" + result + "'", new BeanPropertyRowMapper(User.class));
        //List<Product> productList = jtm.query("select * from public.PRODUCT where product_id =" + productId, new BeanPropertyRowMapper(Product.class));


        return cartuserproduct;
    }





}
