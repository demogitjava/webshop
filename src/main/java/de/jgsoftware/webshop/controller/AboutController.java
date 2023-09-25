package de.jgsoftware.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import de.jgsoftware.webshop.controller.interfaces.i_about;

/**
 *
 * @author hoscho
 */

@Controller
public class AboutController implements i_about {
	ModelAndView mv;

	@Override
	public ModelAndView about() {

		mv = new ModelAndView("about");

		return mv;
	}
}
