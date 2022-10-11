package fi.todo.routine.service;

import fi.todo.routine.entity.RoutineTodoEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IRoutineTodoService {

    List<RoutineTodoEntity> getRoutineTodosByUser(String user);

    Optional<RoutineTodoEntity> getRoutineTodoById(long id);

    void updateRoutineTodo(RoutineTodoEntity routineTodo);

    void deleteRoutineTodo(long id);

    void saveRoutineTodo(RoutineTodoEntity routineTodo);
}
