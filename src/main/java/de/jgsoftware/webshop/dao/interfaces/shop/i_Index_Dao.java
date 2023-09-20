package de.jgsoftware.webshop.dao.interfaces.shop;



import de.jgsoftware.webshop.model.jpa.shopdb.Webtextlayout;
import de.jgsoftware.webshop.model.jpa.demodb.Useragent;
import de.jgsoftware.webshop.model.m_webtextlayout;

import java.util.List;


/**
 *
 * @author hoscho
 */
public interface i_Index_Dao
{
    
   List<m_webtextlayout> getPageLanguageText();
   Useragent saveuseragent(Useragent muagent);
}
