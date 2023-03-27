package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.serivce.interfaces.i_index_service;
import de.jgsoftware.webshop.serivce.interfaces.i_service_products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;

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


    /*
        load products and items
        by default with de
     */
    @Override
    public ModelAndView index()
    {

        mv = new ModelAndView("index");

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


}
