package de.jgsoftware.webshop.serivce.interfaces;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_admin;

/**
 *
 * @author hoscho
 */
public interface i_service_admin {

	i_dao_admin getiDaoAdmin();

	void setiDaoAdmin(i_dao_admin iDaoAdmin);
}