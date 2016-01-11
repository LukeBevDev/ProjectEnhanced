
import com.google.common.collect.ImmutableMap;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Luke on 10-Jan-16.
 */
public class RestServer {

    private static final Logger LOGGER = Logger.getLogger(RestServer.class.getName());

    private static final int PORT = 7070;

    private static final Map<String, String> initParameters = new ImmutableMap.Builder<String, String>()
            .put("jersey.config.server.provider.packages", "com.bevan.projectenhanced.restservice.service")
            .put("jersey.config.server.provider.classnames",  "org.glassfish.jersey.jackson.JacksonFeature")
            .build();

    public static void main(String[] args) throws Exception {
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setContextPath("/");

        Server server = new Server(PORT);
        server.setHandler(contextHandler);

        ServletHolder servletHolder = contextHandler.addServlet(ServletContainer.class, "/*");
        servletHolder.setInitOrder(0);

        servletHolder.setInitParameters(initParameters);

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
