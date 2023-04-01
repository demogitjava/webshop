package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_admin;
import org.springframework.stereotype.Repository;

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


    @Override
    public void hold_ebaytokeninmemory(String ebaytk)
    {


        String ebaytoken = null;

        // load EbayKeys model
        de.jgsoftware.webshop.model.EbayKeys ebaykeys = new de.jgsoftware.webshop.model.EbayKeys();

        ebaytoken = new String(ebaytk);
        ebaykeys.setEbaytoken(ebaytoken);

    }




}
