package service;

import nutricionistPortal.dto.CustomerDTO;
import nutricionistPortal.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointments(CustomerDTO customerDTO) {
        return appointmentRepository.findAll();
    }
}
