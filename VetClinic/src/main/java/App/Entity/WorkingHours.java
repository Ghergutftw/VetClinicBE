package App.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "workingHours")
public class WorkingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "starting_hour")
    private Date startingHour;

    @Column(name = "ending_hour")
    private Date endingHour;

    @Column(name = "status")
    private String status;

    @ManyToOne
    private Doctor doctor;

    public WorkingHours(int id, Date startingHour, Date endingHour, String status, Doctor doctor) {
        this.id = id;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
        this.status = status;
        this.doctor = doctor;
    }

    public WorkingHours() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartingHour() {
        return startingHour;
    }

    public void setStartingHour(Date startingHour) {
        this.startingHour = startingHour;
    }

    public Date getEndingHour() {
        return endingHour;
    }

    public void setEndingHour(Date endingHour) {
        this.endingHour = endingHour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    @Override
    public String toString() {
        return "WorkingHours{" +
                "id=" + id +
                ", startingHour=" + startingHour +
                ", endingHour=" + endingHour +
                ", status='" + status + '\'' +
                ", doctor=" + doctor +
                '}';
    }
}
