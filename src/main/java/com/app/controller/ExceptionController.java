package com.app.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler({Exception.class})
    public String exceptionHandler(Exception exception, Model model) {
        exception.printStackTrace();
        model.addAttribute("error", exception.getMessage());
        model.addAttribute("exceptionType", "FROM CONTROLLER ADVICE: " + exception.getClass());
        return "errorPage";
    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public String exceptionHandlerHttp404(Exception exception, Model model) {
        model.addAttribute("error", exception.getMessage());
        model.addAttribute("exceptionType", "NIE ZNALEZIONO STRONY");
        return "errorPage";
    }
}
