package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.model.USER_PRODUCT_LIST;
import de.jgsoftware.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

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

    public String saveuserdata(String productId, Long userid)
    {

        int prorid = Integer.parseInt(productId);

        jtm.update("INSERT INTO user_product_list (user_id, product_id, id) VALUES (?, ?, ?)", userid, prorid, prorid);

        return "";
    }


    public List getUserId(String stusername)
    {

       List userlistid = jtm.query("select * from users where username like " + "'" + stusername + "'", new BeanPropertyRowMapper(User.class));

       return userlistid;
    }


}


