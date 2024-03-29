package App.RestController;

import App.DTO.DoctorDTO;
import App.Entity.Doctor;
import App.Repository.DoctorRepository;
import App.Service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<DoctorDTO> getDoctors(){
       return doctorService.getDoctors();
    }

    @PostMapping("/doctor")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorDTO doctor){
       doctorService.addDoctor(doctor);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/doctors/{id}")
    public void deleteDoctor(@PathVariable int id){
        doctorService.deleteDoctor(id);
    }

    @PutMapping( "/doctors/{id}")
    public void updateDoctor(@RequestBody DoctorDTO doctor,@PathVariable int id) {
        doctorService.updateDoctor(doctor,id);
    }

    @GetMapping("/doctor/{id}")
    public DoctorDTO getDoctor(@PathVariable int id){
        return doctorService.getDoctorById1(id);
    }

}
