package de.jgsoftware.webshop.dao;

import de.jgsoftware.webshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	User findByEmail(String username);
}
