package de.jgsoftware.webshop.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.jgsoftware.webshop.dao.interfaces.shop.i_Index_Dao;
import de.jgsoftware.webshop.serivce.interfaces.i_index_service;

/**
 *
 * @author hoscho
 */

@Service
public class Index_Service implements i_index_service {

	@Autowired
	i_Index_Dao i_index_dao;

	@Override
	public i_Index_Dao getI_index_dao() {
		return i_index_dao;
	}

	@Override
	public void setI_index_dao(i_Index_Dao i_index_dao) {
		this.i_index_dao = i_index_dao;
	}
}
