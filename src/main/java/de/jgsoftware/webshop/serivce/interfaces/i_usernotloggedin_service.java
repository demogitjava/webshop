package de.jgsoftware.webshop.serivce.interfaces;


import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_usernotloggedin;

/**
 *
 * @author hoscho
 */

public interface i_usernotloggedin_service
{
    i_dao_usernotloggedin getDaoUsernotloggedin();
    void setDaoUsernotloggedin(i_dao_usernotloggedin daoUsernotloggedin);
}
