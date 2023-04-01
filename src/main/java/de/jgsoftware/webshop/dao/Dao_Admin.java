package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_admin;
import org.springframework.stereotype.Repository;

import de.jgsoftware.webshop.model.EbayKeys;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_Admin implements i_dao_admin
{



    @Override
    public void hold_ebayappkeyinmemory(String appid)
    {
        // load EbayKeys model
        de.jgsoftware.webshop.model.EbayKeys ebaykeys = new de.jgsoftware.webshop.model.EbayKeys();

        String ebayappid = new String(appid);
        ebaykeys.setEbayappid(ebayappid);
    }





}
