package de.jgsoftware.webshop.controller.interfaces;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hoscho
 */
@RequestMapping("about")
public interface i_about {
	ModelAndView about();
}
