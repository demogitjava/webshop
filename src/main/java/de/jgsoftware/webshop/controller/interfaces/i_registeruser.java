package de.jgsoftware.webshop.controller.interfaces;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hoscho
 */
@RequestMapping("registeruser")
public interface i_registeruser {


    @GetMapping({"registeruser", "/"})
    ModelAndView registeruser();
}
