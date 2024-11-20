package lk.project.salon.service.impl;

import lk.project.salon.dto.AppointmentDto;
import lk.project.salon.entity.Appointment;
import lk.project.salon.repo.AppointmentRepo;
import lk.project.salon.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private final AppointmentRepo appointmentRepo;

    public AppointmentServiceImpl(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    @Override
    public Object saveAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment(
                appointmentDto.getAppointmentId(),
                appointmentDto.getDate(),
                appointmentDto.getTime(),
                appointmentDto.getStatus(),
                appointmentDto.getExpert(),
                appointmentDto.getName(),
                appointmentDto.getGender(),
                appointmentDto.getPhone()
        );
        return appointmentRepo.save(appointment);

    }

    @Override
    public List<Appointment> getAllAppointment() {
        return appointmentRepo.findAll();
    }

    @Override
    public String deleteAppointment(Integer id) {
       if (appointmentRepo.existsById(id)){
           appointmentRepo.deleteById(id);
           return "Appointment Deleted";
       }
       return  "No Appointment found";
    }
}
