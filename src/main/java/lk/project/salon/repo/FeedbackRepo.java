package lk.project.salon.repo;


import lk.project.salon.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {
}
