package nutricionistPortal.controller;

import nutricionistPortal.dto.AppointmentDayDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import nutricionistPortal.dto.CustomerDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @GetMapping("/appointments")
    public AppointmentListDTO getAppointments(CustomerDTO customerDTO) {
        AppointmentDayDTO appointmentDayDTO = new AppointmentDayDTO(1, null);
        AppointmentListDTO appointmentListDTO = new AppointmentListDTO(Arrays.asList(appointmentDayDTO));
        return appointmentListDTO;
    }
}
