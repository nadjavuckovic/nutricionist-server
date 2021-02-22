package nutricionistPortal.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    private String email;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surname;

    @OneToMany(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
