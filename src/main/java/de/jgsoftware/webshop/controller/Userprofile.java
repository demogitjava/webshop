package de.jgsoftware.webshop.controller;

import de.jgsoftware.webshop.controller.interfaces.i_userprofile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
public class Userprofile implements i_userprofile
{
    @Autowired
    HttpServletRequest request;


    ModelAndView mv;


    @Override
    public ModelAndView userprofile()
    {

        mv = new ModelAndView("userprofile");

        String languagestr = RequestContextUtils.getLocale(request).getLanguage();
        Principal principal = request.getUserPrincipal();


        return mv;
    }


}
