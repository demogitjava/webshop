package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.service.Index_Service;
import de.jgsoftware.webshop.service.User_Service;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class IndexController
{


    @Autowired
    Index_Service indexservice;

    @Autowired
    User_Service userService;

    private Locale locale;




    // DE German
    @GetMapping({"index", "/"})
    public ModelAndView index()
    {


        Map<String, Object> prodtlists = new HashMap<>();
        prodtlists.put("productList", indexservice.getDaoProduct().getProductsforLandingpage());

        prodtlists.put("language", java.util.Locale.getDefault().getCountry());
        return new ModelAndView("index", prodtlists);
    }



    @GetMapping("login")
    public String login() {
        return "login";
    }


    @PostMapping("addProcducttocase")
    public ModelAndView getProduct()
    {
        ModelAndView mv = new ModelAndView("index");


        return mv;
    }


    /*
            loading supported language from browser

     */
    @RequestMapping("fr")
    public String pagefr() {
        return "/fr/index";
    }

    @RequestMapping("en")
    public String pageen() {
        return "/en/index";
    }

    @RequestMapping("it")
    public String pageit() {
        return "/it/index";
    }

    @RequestMapping("tk")
    public String pagetk() {
        return "/tk/index";
    }

    @RequestMapping("es")
    public String pagees() {
        return "/es/index";
    }






}
