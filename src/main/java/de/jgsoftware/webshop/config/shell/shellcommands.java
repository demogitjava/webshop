package de.jgsoftware.webshop.config.shell;

import org.h2.tools.*;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 *
 * @author hoscho
 */

@ShellComponent
public class shellcommands {

	org.h2.tools.Server h2Servertarget;

	@ShellMethod("helpcluster")
	public String helpcluster() {
		System.out.print("start h2 cluster" + "\n");
		System.out.print("----------------" + "\n");
		System.out.print("to start the cluster on the source maschine " + "\n");
		System.out.print("\n");
		System.out.print("\n");
		System.out.print("java org.h2.tools.CreateCluster" + "\n");
		System.out.print("-urlSource jdbc:h2:tcp://localhost:9101/~/demodb" + "\n");
		System.out.print("-urlTarget jdbc:h2:tcp://localhost:9102/~/demodb" + "\n");
		System.out.print("-user root" + "\n");
		System.out.print("-password jj78mvpr52k1" + "\n");
		System.out.print("-serverList 192.168.178.6:9101,192.168.178.7:9102" + "\n");

		System.out.print("------------------------" + "\n");
		System.out.print("192.168.178.6 -> webshop" + "\n");
		System.out.print("192.168.178.7 -> target h2 container" + "\n");

		System.out.print("the url: http://www.h2database.com/html/advanced.html#clustering" + "\n");

		return "----------------------";
	}

	@ShellMethod("help")
	public String help() {
		System.out.print("\n");
		System.out.print("cluster h2 database -> helpcluster" + "\n");
		System.out.print(
				"create a h2 cluster -> startcluster h2 ->  urlsource urltarget user password serverlocal servertaget"
						+ "\n");

		return "----------------------";
	}

	@ShellMethod("create h2 cluster --->  startcluster urlSource urlTaget user password serverList")
	public CreateCluster startcluster(String sturlsource, String sturltarget, String stuser, String stpassword,
			String stservlocal, String stservtarget) {
		/*
		 * 
		 * java org.h2.tools.CreateCluster -urlSource
		 * jdbc:h2:tcp://localhost:9101/~/test -urlTarget
		 * jdbc:h2:tcp://localhost:9102/~/test -user sa -serverList
		 * localhost:9101,localhost:9102
		 * 
		 */

		/*
		 * String urlSource = sturlsource String urlTarget = sturltarget String user =
		 * stuser
		 */
		System.out.print("urlSource" + "\n");
		System.out.print("urlTarget" + "\n");
		System.out.print("username" + "\n");
		System.out.print("password" + "\n");
		System.out.print("ServerList" + "\n" + "first source db" + "\n" + "second targetdb" + "\n");

		org.h2.tools.CreateCluster h2cluster = new org.h2.tools.CreateCluster();

		try {
			h2cluster.execute("-urlSource " + sturlsource, "-urlTarget " + sturltarget, "-user " + stuser,
					"-password " + stpassword, "-serverList " + stservlocal + stservtarget);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return h2cluster;
	}

	@ShellMethod("stopsourceserver")
	public String stopsourceserver() {

		try {

			h2Servertarget.stop();
		} catch (Exception e) {
			System.out.print("Fehler " + e);
		}

		return "server is stopped " + h2Servertarget.getStatus();
	}

	@ShellMethod("statussourceserver")
	public String statussourceserver() {
		try {
			System.out.print("status of h2sourceserver" + h2Servertarget.getStatus() + "\n");
		} catch (Exception e) {
			System.out.print("Fehler " + e);
		}
		return h2Servertarget.getStatus();
	}

	@ShellMethod("startsourceserver")
	public String startsourceserver() {
		// java org.h2.tools.Server
		// -tcp -tcpPort 9101
		// -baseDir server2

		String userdir = System.getProperty("user.home");
		try {

			h2Servertarget = org.h2.tools.Server.createPgServer("-pgAllowOthers");
			h2Servertarget.start();
			String h2status = (String) h2Servertarget.getStatus();
			Integer h2port = (Integer) h2Servertarget.getPort();
			System.out.print("Directory is " + userdir + "\n");

			if (h2Servertarget.isRunning(true)) {
				System.out.print("H2 Clustering startet as server2." + "\n");
			} else {
				throw new RuntimeException("Could not start H2 server." + "\n");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Failed to start H2 server: " + e + "\n");
		}
		return "server status " + h2Servertarget.getStatus();
	}

	// 192.168.178.6 de_webshop
	@ShellMethod("install hosts ---> ihost")
	public String ihosts() {

		String stresolv = new String("host installed");

		File f = new File("/etc/hosts");
		try {

			FileWriter fileWriter = new FileWriter(f);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print("192.168.178.6 de_webshop" + "\n");

			printWriter.close();
		} catch (Exception e) {
			System.out.print("Fehler " + e);
		}
		return stresolv;
	}

	@ShellMethod("install resolvconf ---> iresolvconf")
	public String iresolvconf() {
		String stresolv = new String("resolvconf installed");

		File f = new File("/etc/resolv.conf");
		try {

			FileWriter fileWriter = new FileWriter(f);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.print("search demogitjava freewebshop" + "\n");
			printWriter.print("nameserver 8.8.8.8 8.8.4.4" + "\n");
			printWriter.print("options ndots:0" + "\n");

			printWriter.close();
		} catch (Exception e) {
			System.out.print("Fehler " + e);
		}
		return stresolv;
	}

}
