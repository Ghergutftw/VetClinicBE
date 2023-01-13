package App.Service;

import App.Entity.Doctor;
import java.util.List;
public interface DoctorService {
    List<Doctor> getDoctors();
    void addDoctor(Doctor doctor);
    void deleteDoctor(int id);
    void updateDoctor(Doctor doctor,int id);

    Doctor getDoctorById1(int id);
}
