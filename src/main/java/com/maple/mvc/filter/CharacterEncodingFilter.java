package com.maple.mvc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * desc: CharacterEncodingFilter
 *
 * @author hz.lei
 * @since 2018年08月22日 上午11:07
 */
public class CharacterEncodingFilter implements Filter {

    private String encoding = "UTF-8";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
