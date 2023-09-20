/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.jgsoftware.webshop.dao.interfaces.demodb;

import de.jgsoftware.webshop.model.jpa.demodb.Useragent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author root
 */


@Repository
public interface i_jpa_useragent extends JpaRepository<Useragent, Integer> {
    
}
