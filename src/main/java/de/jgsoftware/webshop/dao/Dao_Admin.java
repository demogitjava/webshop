package de.jgsoftware.webshop.dao;


import de.jgsoftware.webshop.config.EBayConfig;
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
        EBayConfig.listebaykeys.put("appid", appid);
    }


    @Override
    public void hold_ebaytokeninmemory(String ebaytk)
    {
        EBayConfig.listebaykeys.put("ebaytk", ebaytk);
    }


    @Override
    public void hold_certidinmemory(String certid)
    {
        EBayConfig.listebaykeys.put("certid", certid);
    }




}
