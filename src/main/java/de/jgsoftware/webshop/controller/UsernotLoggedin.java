package de.jgsoftware.webshop.controller;

import de.jgsoftware.webshop.controller.interfaces.i_usernotloggendin;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author hoscho
 */
@Controller
public class UsernotLoggedin implements i_usernotloggendin
{

    ModelAndView mv;


    @Override
    public ModelAndView usernotloggedin()
    {

        mv = new ModelAndView("usernotloggedin");




        return mv;
    }
}
