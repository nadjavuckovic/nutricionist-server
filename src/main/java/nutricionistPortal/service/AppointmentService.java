package nutricionistPortal.service;

import lombok.AllArgsConstructor;
import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentDayDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import nutricionistPortal.dto.IAppointmentDTO;
import nutricionistPortal.model.Appointment;
import nutricionistPortal.model.Customer;
import nutricionistPortal.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService {

    @Resource
    private AppointmentRepository appointmentRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public AppointmentListDTO getAppointmentListDTO(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();

        //all appointmenDTOs for given month
        List<IAppointmentDTO> iAppointmentDTOs = appointmentRepository.findAllApointmentsForMonth(month);
        List<AppointmentDTO> appointmentDTOs = modelMapper.map(iAppointmentDTOs, new TypeToken<List<AppointmentDTO>>() {}.getType());

        return populateAppointmentListDTO(appointmentDTOs);
    }

    private AppointmentListDTO populateAppointmentListDTO(List<AppointmentDTO> appointmentDTOs) {
        List<AppointmentDayDTO> appointments = appointmentDTOs
                .stream()
                .map(a -> {
                    int key = a.getDate().getDayOfMonth();
                    return new AppointmentDayDTO(key, appointmentDTOs);
                })
                .collect(Collectors.toList());
        return new AppointmentListDTO(appointments);
    }

    public boolean saveAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO,Appointment.class);

        //temp cause of DozerMapper
        Customer customer = new Customer();
        customer.setEmail("nadjavuckovic@gmail.com");
        appointment.setCustomer(customer);

        appointmentRepository.save(appointment);
        return true;
    }
}
