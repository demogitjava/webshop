package de.jgsoftware.webshop.serivce.interfaces;

import de.jgsoftware.webshop.dao.interfaces.shop.i_Index_Dao;

/**
 *
 * @author hoscho
 */
public interface i_index_service {

	i_Index_Dao getI_index_dao();

	void setI_index_dao(i_Index_Dao i_index_dao);
}
