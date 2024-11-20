package lk.project.salon.controller;

import lk.project.salon.dto.AppointmentDto;
import lk.project.salon.entity.Appointment;
import lk.project.salon.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Object> saveAppointment(@RequestBody AppointmentDto appointmentDto){
        Object newAppointment = appointmentService.saveAppointment(appointmentDto);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllAppointment(){
        List<Appointment> allAppointment = appointmentService.getAllAppointment();
        return new ResponseEntity<>(allAppointment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Integer id){
        String deleted = appointmentService.deleteAppointment(id);
        return new ResponseEntity<>(deleted, HttpStatus.CREATED);
    }

}
