package nutricionistPortal.service;

import com.github.dozermapper.core.Mapper;
import lombok.AllArgsConstructor;
import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentDayDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import nutricionistPortal.model.Appointment;
import nutricionistPortal.repository.AppointmentRepository;
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

    @Resource
    private Mapper dozerBeanMapper;

    public AppointmentListDTO getAppointmentListDTO(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        int year = localDate.getYear();

        List<Appointment> appointments = appointmentRepository.findAllApointmentsForMonth(month, year);
        List<AppointmentDTO> appointmentDTOs = appointments.stream().map(appointment -> {
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            dozerBeanMapper.map(appointment, appointmentDTO);
            return appointmentDTO;
        }).collect(Collectors.toList());

        return populateAppointmentListDTO(appointmentDTOs);
    }

    private AppointmentListDTO populateAppointmentListDTO(List<AppointmentDTO> appointmentDTOs) {
        List<AppointmentDayDTO> appointments = appointmentDTOs
                .stream()
                .map(a -> {
                    int key = a.getDate().getDayOfMonth();
                    AppointmentDayDTO appointmentDayDTO = new AppointmentDayDTO();
                    appointmentDayDTO.setKey(key);
                    appointmentDayDTO.setAppointments(appointmentDTOs);
                    return appointmentDayDTO;
                })
                .collect(Collectors.toList());
        AppointmentListDTO appointmentListDTO = new AppointmentListDTO();
        appointmentListDTO.setAppointments(appointments);
        return appointmentListDTO;
    }

    public boolean saveAppointment(AppointmentDTO appointmentDTO) {
//        Appointment appointment = modelMapper.map(appointmentDTO,Appointment.class);

        //temp cause of DozerMapper
//        Customer customer = new Customer();
//        customer.setEmail("nadjavuckovic@gmail.com");
//        appointment.setCustomer(customer);
//
//        appointmentRepository.save(appointment);
        return true;
    }
}
