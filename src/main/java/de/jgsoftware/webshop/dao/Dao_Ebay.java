package de.jgsoftware.webshop.dao;


import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.AddItemCall;
import com.ebay.sdk.call.VerifyAddItemCall;
import com.ebay.sdk.helper.ConsoleUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.AmountType;
import com.ebay.soap.eBLBaseComponents.BuyerPaymentMethodCodeType;
import com.ebay.soap.eBLBaseComponents.CategoryType;
import com.ebay.soap.eBLBaseComponents.CountryCodeType;
import com.ebay.soap.eBLBaseComponents.CurrencyCodeType;
import com.ebay.soap.eBLBaseComponents.FeesType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDurationCodeType;
import com.ebay.soap.eBLBaseComponents.ListingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.NameValueListArrayType;
import com.ebay.soap.eBLBaseComponents.NameValueListType;
import com.ebay.soap.eBLBaseComponents.ReturnPolicyType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceCodeType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import de.jgsoftware.webshop.config.EBayConfig;
import de.jgsoftware.webshop.model.EbayKeys;
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
