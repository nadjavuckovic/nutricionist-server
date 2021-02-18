package nutricionistPortal.repository;

import nutricionistPortal.dto.IAppointmentDTO;
import nutricionistPortal.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "SELECT a.date as date,a.title as title FROM Appointment a")
    List<IAppointmentDTO> findAllApointmentsForMonth(int month);
}
