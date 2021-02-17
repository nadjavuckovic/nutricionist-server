package nutricionistPortal.facade;

import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.CustomerDTO;

import java.util.List;

public interface AppointmentFacade {

    List<AppointmentDTO> getAppointments(CustomerDTO customerDTO);
}
