package de.jgsoftware.webshop.model.jpa.demodb;


//import javax.persistence.Entity;
//import javax.persistence.Id;

import jakarta.persistence.*;

/**
 *
 * @author hoscho
 */

@Entity
public class Shipping 
{
    @Id
    private Integer id;
    
    private String designation;
    private String designationsize;
    private String country;
    private String shippingprovider;
    private String year;
    private String price;
    private String currency;
    private String storeonline;
    private String dhlzone;
    
}
