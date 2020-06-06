package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.model.USER_PRODUCT_LIST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Doa_UserProductList
{


    @Autowired
    private JdbcTemplate jtm;





    // insert record
    public USER_PRODUCT_LIST saveEntrytoDatabase(USER_PRODUCT_LIST user_product_list)
    {


        jtm.update("insert into user_product_list " +
                        "(user_id, product_id) " +
                        "values (?, ?)",
                user_product_list.getUser_id(),
                user_product_list.getProduct_id());

        return user_product_list;
    }



}


