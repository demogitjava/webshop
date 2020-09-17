package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.model.Kundenstamm;
import de.jgsoftware.webshop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoUser
{


    @Autowired
    private JdbcTemplate jtm;

    public User user;

    public List<Kundenstamm> userlogin;

    public Kundenstamm findByEmail(String email)
    {
        String finuserbyemail = new String("finduserbyemail");
        System.out.print("find user by email query" + "\n" + "\n");


        System.out.print("Find User by Email --------Query" + "\n" + "\n");
        userlogin = jtm.query("select * from kundenstamm where email like " + "'" + email + "'", new BeanPropertyRowMapper(de.jgsoftware.webshop.model.User.class));

       /*
             List<Desktoplayout> loginentry = jtm.query("select * from desktoplayout where framename like " + "'" + result + "'", new BeanPropertyRowMapper(Desktoplayout.class));
        return loginentry;
         */
        return (Kundenstamm) userlogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Kundenstamm> getUserlogin() {
        return userlogin;
    }

    public void setUserlogin(List<Kundenstamm> userlogin) {
        this.userlogin = userlogin;
    }
}
