package App.RestController;

import App.Entity.Doctor;
import App.Service.DoctorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RestControllerDoctor {
    DoctorService doctorService;

    public RestControllerDoctor(DoctorService doctorService) {
        this.doctorService = doctorService;

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


}
