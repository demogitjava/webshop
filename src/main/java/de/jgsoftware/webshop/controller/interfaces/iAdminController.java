package de.jgsoftware.webshop.controller.interfaces;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/admin")
public interface iAdminController
{
    @GetMapping({"admin", "/"})
    ModelAndView admin();

    @GetMapping({"admin", "/de"})
    ModelAndView adminde();


    @GetMapping({"admin", "/ebayuserprofile"})
    ModelAndView ebayuserprofile();


    @PostMapping("/ebayuserprofile/appid")
    String appid(String appid);

}

