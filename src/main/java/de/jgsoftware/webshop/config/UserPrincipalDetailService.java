package de.jgsoftware.webshop.config;


import de.jgsoftware.webshop.dao.UserRepository;
import de.jgsoftware.webshop.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		User user = userRepository.findByEmail(username);
		de.jgsoftware.webshop.config.UserPrincipal userPrincipal = new de.jgsoftware.webshop.config.UserPrincipal(user);
		
		return userPrincipal;
	}
}
