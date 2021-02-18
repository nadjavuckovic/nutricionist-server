package nutricionistPortal;

import lombok.extern.slf4j.Slf4j;
import nutricionistPortal.dto.AppointmentDTO;
import nutricionistPortal.dto.AppointmentListDTO;
import nutricionistPortal.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.util.Date;

@SpringBootTest
@Slf4j
class NutricionistPortalApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	AppointmentService appointmentService;

	@Test
	void appoinments() {
		AppointmentListDTO appointmentListDTO = appointmentService.getAppointmentListDTO(new Date());
		System.out.println(appointmentListDTO.getAppointments().size());
	}

	@Test
	void save() {
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		Date date = new Date();
		appointmentDTO.setDate(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		appointmentDTO.setTitle("Test");
		appointmentService.saveAppointment(appointmentDTO);
	}

}
