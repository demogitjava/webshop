package de.jgsoftware.webshop.controller;

import de.jgsoftware.webshop.controller.interfaces.i_usernotloggendin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import de.jgsoftware.webshop.serivce.interfaces.i_usernotloggedin_service;

/**
 *
 * @author hoscho
 */
@Controller
public class UsernotLoggedin implements i_usernotloggendin
{

    ModelAndView mv;


    @Autowired
    i_usernotloggedin_service iusernotloggedin_service;

    @Override
    public ModelAndView usernotloggedin()
    {

        mv = new ModelAndView("usernotloggedin");

        /**
         *   load entities from table
         *   webtextlayout to contoller
         *
         *   inject text from with webtextcomp[0] fist id of table
         */
        mv.addObject("webtextcomp", iusernotloggedin_service.getDaoUsernotloggedin().getPageLanguageText());
        mv.addObject("productList", iusernotloggedin_service.getDaoUsernotloggedin().getProductsforLandingpage());



        return mv;
    }
}
