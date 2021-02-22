package nutricionistPortal.dto;

import java.util.List;

public class AppointmentDayDTO {

    private int key;
    private List<AppointmentDTO> appointments;

    public AppointmentDayDTO() {
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public List<AppointmentDTO> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentDTO> appointments) {
        this.appointments = appointments;
    }
}
