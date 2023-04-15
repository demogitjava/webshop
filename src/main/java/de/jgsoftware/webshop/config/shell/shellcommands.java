package de.jgsoftware.webshop.config.shell;

import org.springframework.shell.standard.ShellComponent;

import java.sql.SQLException;

import static org.h2.util.IOUtils.copy;
import org.h2.tools.*;
import org.springframework.shell.standard.ShellMethod;

/**
 *
 * @author hoscho
 */

@ShellComponent
public class shellcommands
{


    @ShellMethod("create h2 cluster --->  startcluster urlSource urlTaget user password serverList")
    public CreateCluster startcluster(String sturlsource, String sturltarget, String stuser, String stpassword, String stservlocal, String stservtarget)
    {
        /*

            java org.h2.tools.CreateCluster
                -urlSource jdbc:h2:tcp://localhost:9101/~/test
                -urlTarget jdbc:h2:tcp://localhost:9102/~/test
                -user sa
                -serverList localhost:9101,localhost:9102

         */

        /*
            String urlSource = sturlsource
            String urlTarget = sturltarget
            String user = stuser
         */
        System.out.print("urlSource" + "\n");
        System.out.print("urlTarget" + "\n");
        System.out.print("username" + "\n");
        System.out.print("password" + "\n");
        System.out.print("ServerList" + "\n" + "first source db" + "\n" + "second targetdb" + "\n");


        org.h2.tools.CreateCluster h2cluster = new org.h2.tools.CreateCluster();

        try {
            h2cluster.execute("-urlSource " + sturlsource, "-urlTarget " + sturltarget, "-user " + stuser, "-password " + stpassword, "-serverList " + stservlocal + stservtarget);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return h2cluster;
    }


}
