package App.RestController;

import App.Entity.Doctor;
import App.Repository.DoctorRepository;
import App.Service.DoctorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class RestControllerDoctor {
    DoctorService doctorService;
    DoctorRepository doctorRepository;

    public RestControllerDoctor(DoctorService doctorService, DoctorRepository doctorRepository) {
        this.doctorService = doctorService;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
       return doctorService.getDoctors();
    }

    @PostMapping("/doctor")
    public void addDoctor(@RequestBody Doctor doctor){
       doctorService.addDoctor(doctor);
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable int id){
        doctorService.deleteDoctor(id);
    }

    @PutMapping( "/doctors/{id}")
    public void updateDoctor(@RequestBody Doctor doctor,@PathVariable int id) {
        doctorService.updateDoctor(doctor,id);
    }

    @GetMapping("/doctor/{id}")
    public Doctor getDoctor(@PathVariable int id){
        return doctorRepository.getDoctorById(id);
    }

}
