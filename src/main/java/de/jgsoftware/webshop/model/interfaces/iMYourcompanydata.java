package de.jgsoftware.webshop.model.interfaces;
/**
 *
 * @author hoscho
 */
public interface iMYourcompanydata
{
    public Integer getId();
    public void setId(Integer id);
    public String getFirmenname();
    public void setFirmenname(String firmenname);
    public String getStrasse();
    public void setStrasse(String strasse);
    public Integer getPlz();
    public void setPlz(Integer plz);
    public String getOrt();
    public void setOrt(String ort);
    public String getTelefon();
    public void setTelefon(String telefon);
    public String getEmail();
    public void setEmail(String email);


    public String getSteuernummer();
    public void setSteuernummer(String steuernummer);
    public String getUstIdNr();
    public void setUstIdNr(String ustIdNr);

    public String getGeschfhr();
    public void setGeschfhr(String geschfhr);

    public String getAmtsgericht();
    public void setAmtsgericht(String amtsgericht);
    public String getBank();
    public void setBank(String bank);
    public String getKontoinhaber();
    public void setKontoinhaber(String kontoinhaber);
    public String getIban();
    public void setIban(String iban);

    public Integer getFirmennummer();
    public void setFirmennummer(Integer firmennummer);
}
