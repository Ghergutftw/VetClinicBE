package App.Entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToOne
    private WorkingHours workingHours;

    @ManyToOne
    private Animal animal;

    @OneToOne
    private Prescription prescription;

    @Column
    private String detectedDisease;

    @Column
    private Date intendedHour;

    public Consultation() {

    }

    public Consultation(int id, WorkingHours workingHours, Animal animal, Prescription prescription, String detectedDisease, Date intendedHour) {
        this.id = id;
        this.workingHours = workingHours;
        this.animal = animal;
        this.prescription = prescription;
        this.detectedDisease = detectedDisease;
        this.intendedHour = intendedHour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public String getDetectedDisease() {
        return detectedDisease;
    }

    public void setDetectedDisease(String detectedDisease) {
        this.detectedDisease = detectedDisease;
    }

    public Date getIntendedHour() {
        return intendedHour;
    }

    public void setIntendedHour(Date intendedHour) {
        this.intendedHour = intendedHour;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", workingHours=" + workingHours +
                ", animal=" + animal +
                ", prescription=" + prescription +
                ", detectedDisease='" + detectedDisease + '\'' +
                '}';
    }
}
