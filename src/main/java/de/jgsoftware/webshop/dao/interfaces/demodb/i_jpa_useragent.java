package de.jgsoftware.webshop.dao.interfaces.demodb;

import org.springframework.data.jpa.repository.JpaRepository;
import de.jgsoftware.webshop.model.jpa.demodb.Useragent;

/**
 *
 * @author hoscho
 */
public interface i_jpa_useragent extends JpaRepository<Useragent, Integer>{
    
}
