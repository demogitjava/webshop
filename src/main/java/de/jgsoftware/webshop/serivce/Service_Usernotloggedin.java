package de.jgsoftware.webshop.serivce;


import de.jgsoftware.webshop.serivce.interfaces.i_usernotloggedin_service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_usernotloggedin;

@Service
public class Service_Usernotloggedin implements i_usernotloggedin_service
{

    @Autowired
    i_dao_usernotloggedin daoUsernotloggedin;



    @Override
    public i_dao_usernotloggedin getDaoUsernotloggedin() {
        return daoUsernotloggedin;
    }

    @Override
    public void setDaoUsernotloggedin(i_dao_usernotloggedin daoUsernotloggedin) {
        this.daoUsernotloggedin = daoUsernotloggedin;
    }
}
