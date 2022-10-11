package fi.todo.routine.service;

import fi.todo.routine.entity.RoutineTodoEntity;
import fi.todo.routine.repository.IRoutineTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoutineTodoService implements IRoutineTodoService{

    @Autowired
    private IRoutineTodoRepository routineTodoRepository;

    @Override
    public List<RoutineTodoEntity> getRoutineTodosByUser(String user) {
        return routineTodoRepository.findByUserName(user);
    }

    @Override
    public Optional<RoutineTodoEntity> getRoutineTodoById(long id) {
        return routineTodoRepository.findById(id);
    }

    @Override
    public void updateRoutineTodo(RoutineTodoEntity routineTodo) {
        routineTodoRepository.save(routineTodo);
    }

    @Override
    public void deleteRoutineTodo(long id) {
        Optional<RoutineTodoEntity> routineTodo = routineTodoRepository.findById(id);
        routineTodo.ifPresent(routineTodoEntity -> routineTodoRepository.delete(routineTodoEntity));
    }

    @Override
    public void saveRoutineTodo(RoutineTodoEntity routineTodo) {
        routineTodoRepository.save(routineTodo);
    }
}
