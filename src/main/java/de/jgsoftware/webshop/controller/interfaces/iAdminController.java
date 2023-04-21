package de.jgsoftware.webshop.controller.interfaces;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hoscho
 */

@RequestMapping("/admin")
public interface iAdminController
{
    @GetMapping({"admin", "/"})
    ModelAndView admin();

    @GetMapping({"admin", "/de"})
    ModelAndView adminde();


    @GetMapping({"admin", "/ebayuserprofile"})
    ModelAndView ebayuserprofile();

    @GetMapping({"admin", "/ebayaddproduct"})
    ModelAndView ebayaddproduct();

    @PostMapping("/ebayuserprofile/appid")
    String appid(String appid);

    @PostMapping("/ebayuserprofile/ebaytoken")
    String ebaytoken(String ebaytk);

    @PostMapping("/ebayuserprofile/certid")
    String certid(String certid);
}

