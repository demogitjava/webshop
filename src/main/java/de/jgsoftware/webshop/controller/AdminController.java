package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.controller.interfaces.iAdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AdminController implements iAdminController
{
    @Autowired
    HttpServletRequest request;

    ModelAndView mv;



    @Override
    public ModelAndView admin()
    {

        mv = new ModelAndView("admin");

        String languagestr = RequestContextUtils.getLocale(request).getLanguage();
        Principal principal = request.getUserPrincipal();




        return mv;
    }


    @Override
    public ModelAndView adminde()
    {

        mv = new ModelAndView("admin_de");

        System.out.print("admin de is mvc is loaded");
        return mv;
    }

    @Override
    public ModelAndView ebayuserprofile()
    {
        mv = new ModelAndView("ebayuserprofile");


        mv.addObject("ebaytext", "testtext");
        return mv;
    }
}
