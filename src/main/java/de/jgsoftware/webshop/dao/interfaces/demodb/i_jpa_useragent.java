package de.jgsoftware.webshop.dao.interfaces.demodb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author hoscho
 */

@Repository
public interface i_jpa_useragent extends JpaRepository<de.jgsoftware.webshop.model.jpa.demodb.Useragent, Integer>
{
    
}
