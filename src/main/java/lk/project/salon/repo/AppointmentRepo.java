package lk.project.salon.repo;

import lk.project.salon.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
