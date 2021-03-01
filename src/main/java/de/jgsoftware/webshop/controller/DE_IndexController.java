package de.jgsoftware.webshop.controller;


import de.jgsoftware.webshop.service.Index_Service;
import de.jgsoftware.webshop.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class DE_IndexController
{


    @Autowired
    Index_Service indexservice;

    @Autowired
    User_Service userService;


    @Autowired
    HttpServletRequest request = null;

    public Map<String, Object> prodtlists;



    // DE German
    @GetMapping({"de", "/"})
    public ModelAndView index()
    {
     //Locale locale = (Locale) WebUtils.getSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME);

        prodtlists = new HashMap<>();
        prodtlists.put("productList", indexservice.getDaoProduct().getProductsforLandingpage());

        prodtlists.put("lang", request.getLocale().getLanguage());

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

    @RequestMapping("admin")
    public String pageadmin() {
        return "/admin/index";
    }

    @RequestMapping("manager")
    public String pagemanager() {
        return "/manager/index";
    }


    @PostMapping("searchProduct")
    public ModelAndView searchProduct(@RequestParam(value = "searchProduct", required = false) String searchProduct)
    {

        //Locale locale = (Locale) WebUtils.getSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME);
        prodtlists = new HashMap<>();
        prodtlists.put("productList", indexservice.getDaoProduct().searchProductovertextfield(searchProduct));

        prodtlists.put("lang", request.getLocale().getLanguage());

        return new ModelAndView("index", prodtlists);

    }
}
