package nutricionistPortal.controller;

import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import nutricionistPortal.dto.RequestDTO;
import nutricionistPortal.facade.AppointmentFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.SuccessResponse;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    private static final Logger LOG = LoggerFactory.getLogger(AppointmentController.class);

    @Resource
    AppointmentFacade appointmentFacade;

    @PostMapping("/appointments")
    public AppointmentListDTO getAppointments(RequestDTO requestDTO) {
        try {
            Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(requestDTO.getDate());
            return appointmentFacade.getAppointmentListDTO(selectedDate);
        } catch (ParseException e) {
            LOG.error("Failed to retrieve appointments", e);
            return new AppointmentListDTO();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<SuccessResponse> saveAppointment(AppointmentDTO appointmentDTO) {
        appointmentFacade.saveAppointment(appointmentDTO);
        return ResponseEntity.ok().body(new SuccessResponse(true));
    }
}
