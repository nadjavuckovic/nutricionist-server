package nutricionistPortal.facade;

import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentListDTO;

import java.util.Date;

public interface AppointmentFacade {

    AppointmentListDTO getAppointmentListDTO(Date date);

    boolean saveAppointment(AppointmentDTO appointmentDTO);
}
