package nutricionistPortal.dto;

import java.util.List;

public class AppointmentListDTO {

    private List<AppointmentDayDTO> appointments;

    public AppointmentListDTO() {
    }

    public List<AppointmentDayDTO> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentDayDTO> appointments) {
        this.appointments = appointments;
    }
}
