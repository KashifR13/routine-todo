package fi.todo.routine.controller;

import fi.todo.routine.entity.RoutineTodoEntity;
import fi.todo.routine.service.IRoutineTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("routine-todo")
public class RoutineTodoController {

    @Autowired
    private IRoutineTodoService routineTodoService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllRoutineTodos(ModelMap model) {

        String name = getLoggedInUserName(model);
        model.put("routine_todo", routineTodoService.getRoutineTodosByUser(name));

        return "all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddedRoutineTodoPage(ModelMap model) {

        model.addAttribute("todo", new RoutineTodoEntity());

        return "todo";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRoutineTodo(@RequestParam long id) {

        routineTodoService.deleteRoutineTodo(id);

        return "redirect:/all";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdatedRoutineTodoPage(@RequestParam long id, ModelMap model) {

        RoutineTodoEntity routineTodo = routineTodoService.getRoutineTodoById(id).get();
        model.put("todo", routineTodo);

        return "todo";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRoutineTodo(ModelMap model, @Validated RoutineTodoEntity todo, BindingResult result) {

        if (result.hasErrors()) {return "todo";}

        todo.setUserName(getLoggedInUserName(model));
        routineTodoService.updateRoutineTodo(todo);

        return "redirect:/all";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addRoutineTodo(ModelMap model, @Validated RoutineTodoEntity todo, BindingResult result) {

        if (result.hasErrors()) {return "todo";}

        todo.setUserName(getLoggedInUserName(model));
        routineTodoService.saveRoutineTodo(todo);

        return "redirect:/all";
    }

    private String getLoggedInUserName(ModelMap model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {return ((UserDetails) principal).getUsername();}

        return principal.toString();
    }
}
