package com.maple.mvc.util;


/**
 * desc: WebServerException
 *
 * @author hz.lei
 * @since 2018年08月22日 下午4:23
 */
public class WebServerException extends RuntimeException {

    public WebServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
