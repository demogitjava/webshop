package de.jgsoftware.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import de.jgsoftware.webshop.controller.interfaces.i_registeruser;

/**
 *
 * @author hoscho
 */
@Controller
public class RegisterUser implements i_registeruser {
	ModelAndView mv;

	@Override
	public ModelAndView registeruser() {

		mv = new ModelAndView("registeruser");

		return mv;
	}
}
