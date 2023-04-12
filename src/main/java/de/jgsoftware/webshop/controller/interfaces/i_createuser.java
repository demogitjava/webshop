package de.jgsoftware.webshop.controller.interfaces;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hoscho
 */
@RequestMapping("createuser")
public interface i_createuser {

    @GetMapping({"createuser", "/"})
    ModelAndView createuser();
}

