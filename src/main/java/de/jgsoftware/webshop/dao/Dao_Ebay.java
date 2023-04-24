package de.jgsoftware.webshop.dao;


import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import de.jgsoftware.webshop.config.EBayConfig;
import org.springframework.stereotype.Repository;
import de.jgsoftware.webshop.dao.interfaces.shop.i_dao_ebay;

/**
 *
 * @author hoscho
 */

@Repository
public class Dao_Ebay implements i_dao_ebay
{



    @Override
    public void Ebaystartclient()
    {
        ApiContext apiContext = new ApiContext();
        ApiCredential cred = apiContext.getApiCredential();

        if(EbayKeys.ebaytoken == null)
        {
            System.out.print("================" + "\n");
            System.out.print("no ebay token is in memory" + "\n");
            System.out.print("================" + "\n");
        }

        // model EbayKeys
        cred.seteBayToken(EbayKeys.ebaytoken);

        // url for sandbox
        // https://api.sandbox.ebay.com/wsapi.

        /*
                get String from


                de.jgsoftware.webshop.config.EbayConfig

                if null = Sandbox
                if String is set = Production mode
         */
        apiContext.setApiServerUrl(EBayConfig.ebayserverurl);

        System.out.print("apiContext " + "\n" + apiContext);

    }
}
