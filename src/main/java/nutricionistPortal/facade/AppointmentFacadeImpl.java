package nutricionistPortal.facade;

import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import org.springframework.stereotype.Component;
import nutricionistPortal.service.AppointmentService;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class AppointmentFacadeImpl implements AppointmentFacade {

    @Resource
    private AppointmentService appointmentService;

    @Override
    public AppointmentListDTO getAppointmentListDTO(Date date) {
        return appointmentService.getAppointmentListDTO(date);
    }

    @Override
    public boolean saveAppointment(AppointmentDTO appointmentDTO) {
        return appointmentService.saveAppointment(appointmentDTO);
    }
}
