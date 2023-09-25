package de.jgsoftware.webshop.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_shoppingcart;
import de.jgsoftware.webshop.serivce.interfaces.i_shoppingcart_service;

/**
 *
 * @author hoscho
 */

@Service
public class Shoppingcart_Service implements i_shoppingcart_service {
	@Autowired
	i_dao_shoppingcart shcart;

	public Shoppingcart_Service(i_dao_shoppingcart shcart) {
		this.shcart = shcart;
	}

	public i_dao_shoppingcart getShcart() {
		return shcart;
	}

	public void setShcart(i_dao_shoppingcart shcart) {
		this.shcart = shcart;
	}
}
