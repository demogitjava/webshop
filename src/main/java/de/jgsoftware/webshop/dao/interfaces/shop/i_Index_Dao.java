package de.jgsoftware.webshop.dao.interfaces.shop;


import de.jgsoftware.landingpage.model.jpa.demodb.Webtextlayout;
import de.jgsoftware.webshop.model.m_webtextlayout;
import de.jgsoftware.webshop.model.useragent;

import java.util.List;


/**
 *
 * @author hoscho
 */
public interface i_Index_Dao
{
    
   List<Webtextlayout> getPageLanguageText();
   useragent saveuseragent(useragent muagent);
}
