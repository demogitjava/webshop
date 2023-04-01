package de.jgsoftware.webshop.controller.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



/**
 *
 * @author hoscho
 */

@RequestMapping("/")
public interface IndexController
{

    /**
     *
     * load default shopping page 
     * in german
     * @return 
     */
    @GetMapping({"index", "/"})
    ModelAndView index();

    @PostMapping({"searchProduct", "/productsearch"})
    ModelAndView searchovertextfield(String searchProduct);

    @GetMapping("/userprofile")
    String userprofile();

    @GetMapping("/admin")
    public String admin();
}
