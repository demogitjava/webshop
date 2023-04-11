package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.model.Product;
import de.jgsoftware.webshop.model.m_webtextlayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_usernotloggedin;

import java.util.List;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_Usernotloggedin implements i_dao_usernotloggedin
{
    @Autowired
    @Qualifier(value = "shopJdbcTemplate")
    JdbcTemplate jtm2;

    // demodb
    @Autowired
    @Qualifier(value = "defaultJdbcTemplate")
    JdbcTemplate jtm;



    public List<Product> productList;

    List<m_webtextlayout> webtextlayouts;

    @Override
    public List<Product> getProductsforLandingpage()
    {


        productList = jtm.query("select * from public.PRODUCTS where LANDINGPAGE like '1'", new BeanPropertyRowMapper(Product.class));

        return productList;
    }


    // returns all entriys from Table
    @Override
    public List<m_webtextlayout> getPageLanguageText()
    {
        webtextlayouts = jtm2.query("select * from webtextlayout", new BeanPropertyRowMapper(m_webtextlayout.class));
        return webtextlayouts;
    }


}
