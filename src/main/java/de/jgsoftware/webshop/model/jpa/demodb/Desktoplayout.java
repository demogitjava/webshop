package de.jgsoftware.webshop.model.jpa.demodb;

//import javax.persistence.Entity;
//import javax.persistence.*;
import jakarta.persistence.*;

/**
 *
 * @author hoscho
 */
@Entity
@Table(name = "DESKTOPLAYOUT", schema = "PUBLIC", catalog = "DEMODB")
public class Desktoplayout
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String framename;
    private String de;
    private String fr;
    private String uk;
    private String esp;
    private String it;
    private String tr;
    private String bindto;
    private String guicomponentname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFramename() {
        return framename;
    }

    public void setFramename(String framename) {
        this.framename = framename;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getUk() {
        return uk;
    }

    public void setUk(String uk) {
        this.uk = uk;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getBindto() {
        return bindto;
    }

    public void setBindto(String bindto) {
        this.bindto = bindto;
    }

    public String getGuicomponentname() {
        return guicomponentname;
    }

    public void setGuicomponentname(String guicomponentname) {
        this.guicomponentname = guicomponentname;
    }
}