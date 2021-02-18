package nutricionistPortal.controller;

import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import nutricionistPortal.facade.AppointmentFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.SuccessResponse;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Resource
    AppointmentFacade appointmentFacade;

    @GetMapping("/appointments")
    public AppointmentListDTO getAppointments(Date date) {
        return appointmentFacade.getAppointmentListDTO(date);
    }

    @PostMapping("/save")
    public ResponseEntity<SuccessResponse> saveAppointment(AppointmentDTO appointmentDTO) {
        appointmentFacade.saveAppointment(appointmentDTO);
        return ResponseEntity.ok().body(new SuccessResponse(true));
    }
}
