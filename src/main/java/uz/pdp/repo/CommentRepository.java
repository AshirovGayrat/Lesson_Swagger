package uz.pdp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}