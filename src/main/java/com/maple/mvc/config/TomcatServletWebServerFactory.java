package com.maple.mvc.config;


import com.maple.mvc.controller.HelloServlet;
import com.maple.mvc.util.FileUtil;
import org.apache.catalina.Context;
import org.apache.catalina.Engine;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * desc: TomcatServletWebServerFactory
 *
 * @author hz.lei
 * @since 2018年08月22日 下午2:05
 */
public class TomcatServletWebServerFactory {

    private int port = 8080;

    private final String webappDirLocation = "src/main/webapp/";

    /**
     * The class name of default protocol used.
     */
    public static final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";

    private String protocol = DEFAULT_PROTOCOL;

    private List<TomcatConnectorCustomizer> tomcatConnectorCustomizers = new ArrayList<>();

    private File baseDirectory;


    /**
     * The port that the web server listens on.
     *
     * @return the port
     */
    public int getPort() {
        return this.port;
    }


    public Tomcat getWebServer() throws ServletException {
        Tomcat tomcat = new Tomcat();
        File baseDir = (this.baseDirectory != null ? this.baseDirectory
                : FileUtil.createTempDir("tomcat", getPort()));
        tomcat.setBaseDir(baseDir.getAbsolutePath());

        Connector connector = new Connector(this.protocol);

        tomcat.getService().addConnector(connector);

        customizeConnector(connector);

        tomcat.setConnector(connector);

        tomcat.getHost().setAutoDeploy(false);

        configureEngine(tomcat.getEngine());


        configContext(tomcat);


        return tomcat;
    }

    private void configContext(Tomcat tomcat) throws ServletException {
        Context context = tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());

//        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//        System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());
//
        // Declare an alternative location for your "WEB-INF/classes" dir
        // Servlet 3.0 annotation will work
        File additionWebInfClasses = new File("target/classes");
        WebResourceRoot resources = new StandardRoot(context);

        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);
    }


    /**
     * 设置此*容器上的execute方法调用与其子容器之间的延迟
     *
     * @param engine
     */
    private void configureEngine(Engine engine) {
        engine.setBackgroundProcessorDelay(30);
    }


    private void customizeConnector(Connector connector) {
        int port = (getPort() >= 0 ? getPort() : 0);
        connector.setPort(port);
        connector.setURIEncoding("UTF-8");
        // Don't bind to the socket prematurely if ApplicationContext is slow to start
        connector.setProperty("bindOnInit", "false");

        TomcatConnectorCustomizer compression = new CompressionConnectorCustomizer(
                new Compression());

        compression.customize(connector);


        for (TomcatConnectorCustomizer customizer : this.tomcatConnectorCustomizers) {
            customizer.customize(connector);
        }
    }


}
