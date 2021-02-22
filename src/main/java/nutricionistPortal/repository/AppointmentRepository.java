package nutricionistPortal.repository;

import nutricionistPortal.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "SELECT a FROM Appointment a WHERE MONTH(a.date) = :month")
    List<Appointment> findAllApointmentsForMonth(int month);
}
