package com.maple.mvc.config;


/**
 * Simple interface that represents a fully configured web server (for example Tomcat,
 * Jetty, Netty). Allows the server to be {@link #start() started} and {@link #stop()
 * stopped}.
 *
 * @author hz.lei
 * @author Phillip Webb
 * @author Dave Syer
 * @since 2018年08月22日 下午2:09
 */
public interface WebServer {

    /**
     * Starts the web server. Calling this method on an already started server has no
     * effect.
     *
     * @throws Exception if the server cannot be started
     */
    void start() throws Exception;

    /**
     * Stops the web server. Calling this method on an already stopped server has no
     * effect.
     *
     * @throws Exception if the server cannot be stopped
     */
    void stop() throws Exception;

    /**
     * Return the port this server is listening on.
     *
     * @return the port (or -1 if none)
     */
    int getPort();

}

