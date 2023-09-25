package de.jgsoftware.webshop.dao.interfaces.shop;

import java.util.List;

import de.jgsoftware.webshop.model.Users;
import de.jgsoftware.webshop.model.shoppingcart;

/**
 *
 * @author hoscho
 */
public interface i_dao_shoppingcart {

	/*
	 * return the username and the id as list from table users in -> demodb
	 */
	List<Users> getloggedinuserdata(String stusername);

	/*
	 * 
	 * save id user_id and product_id
	 * 
	 * into table shoppingcart -> shopdb
	 */
	public List saveprodcut(List<shoppingcart> shoppingcart);
}
