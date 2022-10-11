package fi.todo.routine.repository;

import fi.todo.routine.entity.RoutineTodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoutineTodoRepository extends JpaRepository<RoutineTodoEntity, Long> {

    List<RoutineTodoEntity> findByUserName(String userName);
}
