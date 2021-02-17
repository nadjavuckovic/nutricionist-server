package nutricionistPortal.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {

    private LocalDateTime date;
    private String title;
    private CustomerDTO customer;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }
}
