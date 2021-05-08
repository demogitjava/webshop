package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.model.Kundenstamm;
import de.jgsoftware.webshop.model.PRODUCT_CHECK_OUT_TEXT;
import de.jgsoftware.webshop.model.USER_PRODUCT_LIST;

import de.jgsoftware.webshop.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.management.Query;
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


        try {
            jtm.update("INSERT INTO user_product_list (user_id, product_id, id) VALUES (?, ?, ?)", userid, prorid, prorid);

        } catch(Exception e)
        {
            // User Product exist in Product Table

            System.out.print("product exist");
        }
        return "userproduct_saved";
    }


    public List getUserId(String stusername)
    {

       List userlistid = jtm.query("select * from users where username like " + "'" + stusername + "'", new BeanPropertyRowMapper(Users.class));

       return userlistid;
    }

    public List getUserdataafterLogin(String stusername)
    {
        List userlistid = jtm.query("select * from users where username like " + "'" + stusername + "'", new BeanPropertyRowMapper(Users.class));
        return userlistid;
    }

    public List getCustomerdataoveremail(String stemail)
    {
        List customeroveremail = jtm.query("select * from kundenstamm where email like " + "'" + stemail + "'", new BeanPropertyRowMapper(Kundenstamm.class));

        return customeroveremail;
    }

    public List getCheckoutdata(Integer id_kundernumber)
    {
        /*
        select * from KUNDENSTAMM
                  left join USER_PRODUCT_LIST on KUNDENSTAMM.ID = USER_PRODUCT_LIST.USER_ID
                  left outer join PRODUCT_CHECK_OUT_TEXT on PRODUCT_ID = ID_PRODUCTS;
         */


        //select * from KUNDENSTAMM JOIN USER_PRODUCT_LIST on KUNDENSTAMM.ID = USER_ID join PRODUCT_CHECK_OUT_TEXT on USER_PRODUCT_LIST.PRODUCT_ID = PRODUCT_CHECK_OUT_TEXT.ID_PRODUCTS where KUNDENSTAMM.ID like '1';

        Kundenstamm kdstamm = new Kundenstamm();


        /*
        Query query = em.createNativeQuery("SELECT u.name,s.something FROM user u, someTable s WHERE s.user_id = u.id");
        List list = query.getResultList();
         */

        /*
        query = session.createSQLQuery("select {e.*}, {a.*} from Employee e join Address a ON e.emp_id=a.emp_id")
		.addEntity("e",Employee.class)
		.addJoin("a","e.address");
rows = query.list();



 List customercheckout = (List) jtm.query("select * from KUNDENSTAMM JOIN USER_PRODUCT_LIST on KUNDENSTAMM.ID = USER_ID join PRODUCT_CHECK_OUT_TEXT on USER_PRODUCT_LIST.PRODUCT_ID = PRODUCT_CHECK_OUT_TEXT.ID_PRODUCTS where KUNDENSTAMM.ID like " + "'" + id_kundernumber + "'", new BeanPropertyRowMapper(kdstamm.getClass()));

         */



        List customercheckout = (List) jtm.query("select * from KUNDENSTAMM JOIN USER_PRODUCT_LIST on KUNDENSTAMM.ID = USER_ID join PRODUCT_CHECK_OUT_TEXT on USER_PRODUCT_LIST.PRODUCT_ID = PRODUCT_CHECK_OUT_TEXT.ID_PRODUCTS where KUNDENSTAMM.ID like " + "'" + id_kundernumber + "'", new BeanPropertyRowMapper(kdstamm.getClass()));


        return customercheckout;
    }


}


