package lk.project.salon.service;

import lk.project.salon.dto.AppointmentDto;
import lk.project.salon.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    Object saveAppointment(AppointmentDto appointmentDto);

    List<Appointment> getAllAppointment();

    String deleteAppointment(Integer id);
}
