package de.jgsoftware.webshop.dao.interfaces.shop;


import de.jgsoftware.webshop.model.Product;
import de.jgsoftware.webshop.model.m_webtextlayout;

import java.util.List;

/**
 *
 * @author hoscho
 */
public interface i_dao_usernotloggedin
{
    List<m_webtextlayout> getPageLanguageText();
    List<Product> getProductsforLandingpage();
}
