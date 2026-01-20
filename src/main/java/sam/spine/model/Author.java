package sam.spine.model;

import jakarta.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String first_name;
    private String last_name;
    private String pen_name;

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String name) {
        this.first_name = name;
    }

    public String getLastName() {
        return last_name;
    }

    private void setLastName(String name) {
        this.last_name = name;
    }

    private String getPenName() {
        return this.pen_name;
    }

    private void setPenName(String name) {
        this.pen_name = name;
    }
}
