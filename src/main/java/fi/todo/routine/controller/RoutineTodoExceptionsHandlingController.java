package fi.todo.routine.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class RoutineTodoExceptionsHandlingController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(HttpServletRequest request, Exception ex) {

        ModelAndView exceptionHandlerModelView = new ModelAndView();

        exceptionHandlerModelView.addObject("exception", ex.getLocalizedMessage());
        exceptionHandlerModelView.addObject("url", request.getRequestURL());

        exceptionHandlerModelView.setViewName("error");

        return exceptionHandlerModelView;
    }
}


