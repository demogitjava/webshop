package de.jgsoftware.webshop.model;


import javax.persistence.*;
import javax.persistence.Id;

import java.util.List;

@Entity
@Table(name = "USER_PRODUCT_LIST")
public class USER_PRODUCT_LIST
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int user_id;

    private long product_id;


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }
}
