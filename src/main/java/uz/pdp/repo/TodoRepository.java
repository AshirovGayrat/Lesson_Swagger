package uz.pdp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}