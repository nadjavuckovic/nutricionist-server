package nutricionistPortal.facade;

import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.CustomerDTO;
import org.dozer.DozerBeanMapper;
import service.AppointmentService;

import javax.annotation.Resource;
import java.util.List;

public class AppointmentFacadeImpl implements AppointmentFacade {

    @Resource
    private DozerBeanMapper dozerBeanMapper;

    @Resource
    private AppointmentService appointmentService;

    @Override
    public List<AppointmentDTO> getAppointments(CustomerDTO customerDTO) {
        return (List<AppointmentDTO>) dozerBeanMapper.map(appointmentService.getAppointments(customerDTO), AppointmentDTO.class);
    }
}
