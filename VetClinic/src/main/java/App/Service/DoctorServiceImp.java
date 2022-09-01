package App.Service;

import App.Entity.Doctor;
import App.Repository.DoctorRepository;
import App.Repository.UserRepository;
import App.Repository.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImp implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final WorkingHoursRepository workingHoursRepository;
    private final UserRepository userRepository;
    @Autowired
    public DoctorServiceImp(DoctorRepository doctorRepository, WorkingHoursRepository workingHoursRepository, UserRepository userRepository) {
        this.doctorRepository = doctorRepository;
        this.workingHoursRepository = workingHoursRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        System.out.println("ADDED!");
    }

    @Override
    public void deleteDoctor(int id) {
        doctorRepository.deleteById(id);
        System.out.println("Delete!");
    }

    @Override
    public void updateDoctor(Doctor doctor, int id) {
        doctor.setId(id);
        doctorRepository.save(doctor);
    }
}
