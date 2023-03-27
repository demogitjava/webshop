package de.jgsoftware.webshop.controller;


import org.springframework.stereotype.Controller;
import de.jgsoftware.webshop.controller.interfaces.i_about;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.security.Principal;

@Controller
public class AboutController implements i_about
{
    ModelAndView mv;
    @Override
    public ModelAndView about()
    {

        mv = new ModelAndView("about");




        return mv;
    }
}
