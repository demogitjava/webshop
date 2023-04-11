package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.model.useragent;
import de.jgsoftware.webshop.serivce.interfaces.i_index_service;
import de.jgsoftware.webshop.serivce.interfaces.i_service_products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;
import java.util.HashMap;

import ua_parser.Parser;
import ua_parser.Client;
/**
 *
 * @author hoscho
 */

@Controller
public class IndexController implements de.jgsoftware.webshop.controller.interfaces.IndexController {

    java.util.Locale locale;

    HashMap prodtlists;

    @Autowired
    i_service_products iserviceproducts;
    
    @Autowired
    HttpServletRequest request;
    
    ModelAndView mv;
   
    @Autowired
    i_index_service index_service;

    String languagestr;

    Principal principal;

    /*
        load products and items
        by default with de
     */
    @Override
    public ModelAndView index()
    {
        /*

            save header form useragent to
            table USERAGENT

         */

        // ip address client
        String ipAddress = request.getRemoteAddr();

        String stuseragent = request.getHeader("user-agent");

        Parser uaParser = new Parser();
        Client c = uaParser.parse(stuseragent);

        String stbrowser = c.userAgent.family; // browser
        String stbrowserversion = c.userAgent.family; // browser version
        String stsystem = c.os.family; // operation system

        /*
        System.out.println(c.userAgent.family); // => browser
        System.out.println(c.userAgent.major);  // => browser version
        System.out.println(c.userAgent.minor);  // => "1"
        System.out.println(c.os.family);        // => operation system
           */

        // browser language like "de"
        languagestr = RequestContextUtils.getLocale(request).getLanguage();

        Date date = new Date();

        useragent muagent = new useragent();
        muagent.setIpAddress(ipAddress);
        muagent.setStbrowser(stbrowser);
        muagent.setStbrowserversion(stbrowserversion);
        muagent.setStsystem(stsystem);
        muagent.setStlanguage(languagestr);
        muagent.setDate(date);
        //=======================================


        /*
                save pojo
              de.jgsoftware.webshop.model.useragent
         */
        index_service.getI_index_dao().saveuseragent(muagent);


        /*

                begin MVC Controller de

         */

        mv = new ModelAndView("index");

        languagestr = RequestContextUtils.getLocale(request).getLanguage();
        principal = request.getUserPrincipal();


        mv = new ModelAndView("de");


        /*
                user login
         */
        if(principal == null)
        {
            System.out.print("not login");
        }
        else {
            mv.addObject("lgusername", "User: " + principal.getName());
        }

        /**
         *   Get Country to display Language
         *   only for this Controller
         */

        mv.addObject("lang", languagestr);


        /**
         *   load entities from table
         *   webtextlayout to contoller
         *
         *   inject text from with webtextcomp[0] fist id of table
         */
        mv.addObject("webtextcomp", index_service.getI_index_dao().getPageLanguageText());

        mv.addObject("productList", iserviceproducts.getIdaoproducts().getProductsforLandingpage());

        return mv;
    }


    /*

        load items over search string
        -> String searchProduct


     */
    @Override
    public ModelAndView searchovertextfield(String searchProduct)
    {
        mv = new ModelAndView("searchProduct");

        String languagestr = RequestContextUtils.getLocale(request).getLanguage();
        Principal principal = request.getUserPrincipal();
        mv = new ModelAndView("de");


        /*
                user login
         */
        if(principal == null)
        {
            System.out.print("not login");
        }
        else {
            mv.addObject("lgusername", "User: " + principal.getName());
        }

        /**
         *   Get Country to display Language
         *   only for this Controller
         */

        mv.addObject("lang", languagestr);


        /**
         *   load entities from table
         *   webtextlayout to contoller
         *
         *   inject text from with webtextcomp[0] fist id of table
         */
        mv.addObject("webtextcomp", index_service.getI_index_dao().getPageLanguageText());

        mv.addObject("productList", iserviceproducts.getIdaoproducts().searchProductop25(searchProduct));






        return mv;
    }



    @Override
    public String userprofile()
    {
        return "redirect:/userprofile/";
    }


    @Override
    public String admin()
    {
        return "redirect:/admin/";
    }


    @Override
    public String usernotloggedin()
    {
        return "redirect:/usernotloggedin/";
    }

}
