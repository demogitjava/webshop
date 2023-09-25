package de.jgsoftware.webshop.dao.interfaces.shop;

/**
 *
 * @author hoscho
 */
public interface i_dao_admin {
	void hold_ebayappkeyinmemory(String appid);

	void hold_ebaytokeninmemory(String ebaytk);

	void hold_certidinmemory(String certid);

}
