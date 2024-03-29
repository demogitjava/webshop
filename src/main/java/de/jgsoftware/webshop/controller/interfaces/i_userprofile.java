package de.jgsoftware.webshop.controller.interfaces;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hoscho
 */

@RequestMapping("userprofile")
@PreAuthorize("hasAuthority('ROLE_ADMIN','ROLE_USER')")
public interface i_userprofile {

	@GetMapping({ "userprofile", "/" })
	ModelAndView userprofile();
}
