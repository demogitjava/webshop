package de.jgsoftware.webshop.serivce.interfaces;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_shoppingcart;

/**
 *
 * @author hoscho
 */

public interface i_shoppingcart_service {
	i_dao_shoppingcart getShcart();

	void setShcart(i_dao_shoppingcart shcart);
}
