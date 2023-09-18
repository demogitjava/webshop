package de.jgsoftware.webshop.model;

import java.util.Date;
import jakarta.persistence.*;
/**
 *
 * @author hoscho
 */

public class m_EbayaddItem
{
    // ebay auction
    // 1 = true
    // 2 = false
    public int fAution = 1;

    public double preis = Double.parseDouble(null);


    //
    // ebay condition#
    // new = 1
    // needed = 2;
    public int isnew = 1;


    // default 7 days
    public int offerduration = 7;

    // Shipping
    // in demo only dhl
    public String de_shipping = "DHL";

    // Shipping price
    public double shippingprice = Double.parseDouble(null);


    // shipping world
    public String worldshipping = "";


    // price shipping world
    public double worldpriceshipping = Double.parseDouble(null);



    /*
        write picture as array -> byte

        BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );
        byte [] data = bos.toByteArray();

     */
    public byte[] productpicture = null;


    /*

        return date for ebay
        when start

     */
    public Date startdate = null;




}
