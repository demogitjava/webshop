package de.jgsoftware.webshop.config;


import org.springframework.context.annotation.Configuration;


/**
 *
 * @author hoscho
 */

@Configuration
public class EBayConfig
{


    /*

        Sandbox Gateway URL (endpoint):
        https://api.sandbox.ebay.com/wsapi

        Production Gateway URL (endpoint):
        https://api.ebay.com/wsapi

     */
    public static String ebayserverurl = null;

    public EBayConfig()
    {
        // started ebay config with String
        // serverurl = null
        // if null then sandbox
        // else production


        if(ebayserverurl == null)
        {
            setSandboxurl(ebayserverurl);
        }
        else
        {
            setProductionURL(ebayserverurl);
        }

    }

    public String setSandboxurl(String ebayserverurl)
    {

        ebayserverurl = new String("https://api.sandbox.ebay.com/wsapi");
        
        System.out.print("The URL is Sandbox " + "\n");
        System.out.print("The String is " + ebayserverurl + "\n");
        System.out.print("================" + "\n");
        
        
        return ebayserverurl;
    }

    public String setProductionURL(String ebayserverurl)
    {
        ebayserverurl = new String("https://api.sandbox.ebay.com/wsapi");


        System.out.print("The URL is PRODUCTION MODE " + "\n");
        System.out.print("The String is " + ebayserverurl + "\n");
        System.out.print("================" + "\n");
        
        return ebayserverurl;
    }

    
}
