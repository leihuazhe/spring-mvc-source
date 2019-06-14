package com.maple.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author <a href=mailto:leihuazhe@gmail.com>maple</a>
 * @since 2018-10-29 11:17 AM
 */
@Controller
@RequestMapping(value = "exception")
public class ExController {


    @ExceptionHandler({NullPointerException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleNullPointerException(Exception e) {
        e.printStackTrace();
        return "error";
    }

    @RequestMapping(value = "e3/{id}", method = {RequestMethod.GET})
    @ResponseBody
    public String testExceptionHandle3(@PathVariable(value = "id") Integer id) {
        List<String> list = 4 % id == 0 ? null : Arrays.asList("a", "b", "c", "d");
        return list.get(id);
    }

    @SafeVarargs
    public final <T> T[] of(T... args) {
        return args;
    }

}
