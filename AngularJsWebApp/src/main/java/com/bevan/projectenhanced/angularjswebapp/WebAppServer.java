package com.bevan.projectenhanced.angularjswebapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.util.logging.Logger;

/**
 * Created by Luke on 12-Jan-16.
 */
public class WebAppServer {

    private static final Logger LOGGER = Logger.getLogger(WebAppServer.class.getName());

    private static final int PORT = 8080;
    private static final String webAppDir = "src/main/webapp/";

    public static void main(String[] args) {
        Server server = new Server(PORT);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setDescriptor(webAppDir + "/WEB-INF/web.xml");
        webAppContext.setResourceBase(webAppDir);

        server.setHandler(webAppContext);

        try {
            LOGGER.info("Starting server.....");
            server.start();
            server.join();
        } catch(Exception e) {
            LOGGER.severe("Exception thrown in RestServer");
            LOGGER.severe("Stacktrace: " + e.getStackTrace());
        } finally {
            server.destroy();
        }
    }
}
