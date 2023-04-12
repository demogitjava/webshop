package de.jgsoftware.webshop.controller;

import de.jgsoftware.webshop.controller.interfaces.i_registeruser;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author hoscho
 */
@Controller
public class RegisterUser implements i_registeruser
{
    ModelAndView mv;


    @Override
    public ModelAndView registeruser() {

        mv = new ModelAndView("registeruser");


        return mv;
    }
}
