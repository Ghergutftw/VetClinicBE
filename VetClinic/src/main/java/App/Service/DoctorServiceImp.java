package App.Service;

import App.DTO.DoctorDTO;
import App.DTO.WorkingHoursDTO;
import App.Entity.Doctor;
import App.Entity.WorkingHours;
import App.Repository.ConsultationRepository;
import App.Repository.DoctorRepository;
import App.Repository.UserRepository;
import App.Repository.WorkingHoursRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
@Service
@Transactional
public class DoctorServiceImp implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final WorkingHoursRepository workingHoursRepository;
    private final ConsultationRepository consultationRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public DoctorServiceImp(DoctorRepository doctorRepository, WorkingHoursRepository workingHoursRepository,
                            ConsultationRepository consultationRepository) {
        this.doctorRepository = doctorRepository;
        this.workingHoursRepository = workingHoursRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public List<DoctorDTO> getDoctors() {
        List<Doctor> doctors=doctorRepository.findAll();
        List<DoctorDTO> doctorDTO = new ArrayList<>();
        for (Doctor doctor:doctors) {
            doctorDTO.add(modelMapper.map(doctor,DoctorDTO.class));
        }
        return doctorDTO;
    }

    @Override
    public void addDoctor(DoctorDTO doctor) {
        doctor.getUser().setPassword(new String(Base64.getEncoder().encode(doctor.getUser().getPassword().getBytes())));
        Doctor doctorEntity = modelMapper.map(doctor,Doctor.class);
        doctorRepository.save(doctorEntity);
        System.out.println("ADDED!");
    }


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
    public void updateDoctor(DoctorDTO doctor, int id) {
        doctor.setId(id);
        Doctor doctorEntity = new Doctor();
        modelMapper.map(doctor,doctorEntity);
        doctorRepository.save(doctorEntity);
    }

    public DoctorDTO getDoctorById1(int id) {
        DoctorDTO doctor = modelMapper.map(doctorRepository.getDoctorById(id),DoctorDTO.class);
        doctor.getUser().setPassword(new String(Base64.getDecoder().decode(doctor.getUser().getPassword())));
        return doctor;
    }
}
