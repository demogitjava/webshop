package de.jgsoftware.webshop.model.jpa.shopdb;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * @author hoscho
 */
@Entity
public class User_Product_list {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
      
    private Integer product_id;
    private Integer id;
    
}
