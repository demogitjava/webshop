package de.jgsoftware.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import de.jgsoftware.webshop.controller.interfaces.i_createuser;

/**
 *
 * @author hoscho
 */
@Controller
public class CreateUser implements i_createuser {

	ModelAndView mv;

	@Override
	public ModelAndView createuser() {

		mv = new ModelAndView("createuser");

		return mv;
	}
}
