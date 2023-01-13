package App.Service;

import App.Entity.Doctor;
import App.Entity.WorkingHours;
import App.Repository.ConsultationRepository;
import App.Repository.DoctorRepository;
import App.Repository.UserRepository;
import App.Repository.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.List;
@Service
public class DoctorServiceImp implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final WorkingHoursRepository workingHoursRepository;
    private final ConsultationRepository consultationRepository;

    @Autowired
    public DoctorServiceImp(DoctorRepository doctorRepository, WorkingHoursRepository workingHoursRepository,
                            ConsultationRepository consultationRepository) {
        this.doctorRepository = doctorRepository;
        this.workingHoursRepository = workingHoursRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctor.getUser().setPassword(new String(Base64.getEncoder().encode(doctor.getUser().getPassword().getBytes())));
        doctorRepository.save(doctor);
        System.out.println("ADDED!");
    }

    @Transactional
    @Override
    public void deleteDoctor(int id) {
        List<WorkingHours> workingHoursList = workingHoursRepository.getAllByDoctor_Id(id);
        for(WorkingHours workingHours : workingHoursList){
            consultationRepository.deleteAllByWorkingHours(workingHours);
        }
        workingHoursRepository.deleteAllByDoctor_Id(id);
        doctorRepository.deleteById(id);
        System.out.println("Delete!");
    }

    @Override
    public void updateDoctor(Doctor doctor, int id) {
        doctor.setId(id);
        doctorRepository.save(doctor);
    }

    public Doctor getDoctorById1(int id) {
        Doctor doctor = doctorRepository.getDoctorById(id);
        doctor.getUser().setPassword(new String(Base64.getDecoder().decode(doctor.getPassword())));
        return doctor;
    }
}
