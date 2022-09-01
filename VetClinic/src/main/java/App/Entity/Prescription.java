package App.Entity;

import javax.persistence.*;
@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;

    @Column
    private String Treatment;

    public Prescription(int id, String treatment) {
        this.id = id;
        Treatment = treatment;
    }

    public Prescription() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTreatment() {
        return Treatment;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", Treatment='" + Treatment + '\'' +
                '}';
    }
}
