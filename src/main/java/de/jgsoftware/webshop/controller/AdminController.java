package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.controller.interfaces.iAdminController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

import de.jgsoftware.webshop.serivce.interfaces.i_service_admin;

/**
 *
 * @author hoscho
 */

@Controller
public class AdminController implements iAdminController
{
    @Autowired
    HttpServletRequest request;

    ModelAndView mv;


    @Autowired
    i_service_admin service_admin;


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

    @Override
    public String appid(String appid)
    {

        // String appid - ebay_appid
        service_admin.getiDaoAdmin().hold_ebayappkeyinmemory(appid);
        return "admin";
    }


    @Override
    public String ebaytoken(String ebaytk)
    {
        // String ebaytk - ebaytk
        service_admin.getiDaoAdmin().hold_ebaytokeninmemory(ebaytk);
        return "admin";
    }





    @Override
    public String certid(String certid)
    {

        // String certid - certid
        service_admin.getiDaoAdmin().hold_certidinmemory(certid);
        return "admin";
    }
}
