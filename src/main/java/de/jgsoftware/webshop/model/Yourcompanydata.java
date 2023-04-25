package de.jgsoftware.webshop.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author hoscho
 */

@Entity
public class Yourcompanydata
{

    @Id
    private Integer id;
   
    private String firmenname;
    private String strasse;

    private Integer plz;
    private String ort;
    private String telefon;
    private String email;



    private Integer firmennummer;

    private String steuernummer;
    private String UstIdNr;
    private String geschfhr;
    private String amtsgericht;
    private String bank;
    private String kontoinhaber;
    private String iban;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFirmennummer() {
        return firmennummer;
    }

    public void setFirmennummer(Integer firmennummer) {
        this.firmennummer = firmennummer;
    }

    public String getSteuernummer() {
        return steuernummer;
    }

    public void setSteuernummer(String steuernummer) {
        this.steuernummer = steuernummer;
    }

    public String getUstIdNr() {
        return UstIdNr;
    }

    public void setUstIdNr(String ustIdNr) {
        UstIdNr = ustIdNr;
    }

    public String getGeschfhr() {
        return geschfhr;
    }

    public void setGeschfhr(String geschfhr) {
        this.geschfhr = geschfhr;
    }

    public String getAmtsgericht() {
        return amtsgericht;
    }

    public void setAmtsgericht(String amtsgericht) {
        this.amtsgericht = amtsgericht;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getKontoinhaber() {
        return kontoinhaber;
    }

    public void setKontoinhaber(String kontoinhaber) {
        this.kontoinhaber = kontoinhaber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
