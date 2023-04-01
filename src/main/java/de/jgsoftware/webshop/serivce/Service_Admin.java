package de.jgsoftware.webshop.serivce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.serivce.interfaces.i_service_admin;
import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_admin;

/**
 *
 * @author hoscho
 */

@Service
public class Service_Admin implements i_service_admin
{
    @Autowired
    i_dao_admin iDaoAdmin;


    @Override
    public i_dao_admin getiDaoAdmin() {
        return iDaoAdmin;
    }


    @Override
    public void setiDaoAdmin(i_dao_admin iDaoAdmin) {
        this.iDaoAdmin = iDaoAdmin;
    }
}
