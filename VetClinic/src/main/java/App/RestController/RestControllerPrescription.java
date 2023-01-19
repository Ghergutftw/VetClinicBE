package App.RestController;

import App.DTO.PrescriptionDTO;
import App.Entity.Prescription;
import App.Service.PrescriptionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class RestControllerPrescription {
    PrescriptionService prescriptionService;

    public RestControllerPrescription(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/prescription/{id}")
    public void getPrescription(@PathVariable int id){
        prescriptionService.getPrescription(id);
    }

    @GetMapping("/prescriptions")
    public List<PrescriptionDTO> showAllPrescriptions(){
       return prescriptionService.showAllPrescriptions();
    }

    @DeleteMapping("prescription/{id}")
    public void deletePrescription(@PathVariable int id){
        prescriptionService.deletePrescription(id);
    }





}
