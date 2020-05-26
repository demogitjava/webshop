package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DaoLogin
{

    @Autowired
    private JdbcTemplate jtm;


    /*

        query
        USERDETAILS  // -> String username

     */
    public List<User> getUserInformationLogin(String username)
    {

        String result = String.valueOf(username);

        String sql = "select * from userdetails where username like " + "'" + result + "'";
        System.out.print(sql + "\n" + "\n");
        List<User> userdetails = jtm.query("select * from USERDETAIL where username like " + "'" + result + "'", new BeanPropertyRowMapper(User.class));
        return userdetails;
    }


    /*

        load default blank UserList
        after sucess login

     */
    public List<User> getUserbyLoginForm(String email)
    {
        String result = String.valueOf(email);

        String searchuserbyemail = "";
        List<User> defaultUserConfigList = jtm.query("select * from USER where email like " + "'" + result + "'", new BeanPropertyRowMapper(User.class));

        return defaultUserConfigList;
    }


    public User decodepassword()
    {

        User usermodel = new User();
        String userpassword = usermodel.getPassword();

        return usermodel;
    }


}
