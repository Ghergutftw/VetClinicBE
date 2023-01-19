package App.Service;

import App.DTO.DoctorDTO;
import App.Entity.Doctor;
import java.util.List;
public interface DoctorService {
    List<DoctorDTO> getDoctors();
    void addDoctor(DoctorDTO doctor);
    void deleteDoctor(int id);
    void updateDoctor(DoctorDTO doctor,int id);

    DoctorDTO getDoctorById1(int id);
}
