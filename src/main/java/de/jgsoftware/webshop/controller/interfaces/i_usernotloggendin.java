package de.jgsoftware.webshop.controller.interfaces;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hoscho
 */
@RequestMapping("usernotloggedin")
public interface i_usernotloggendin {


    @GetMapping({"usernotloggedin", "/usernotloggedin"})
    ModelAndView usernotloggedin();
}
