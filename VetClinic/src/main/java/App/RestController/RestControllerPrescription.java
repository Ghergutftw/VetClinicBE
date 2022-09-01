package App.RestController;

import App.Entity.Prescription;
import App.Service.PrescriptionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
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
    public List<Prescription> showAllPrescriptions(){
       return prescriptionService.showAllPrescriptions();
    }

    @DeleteMapping("prescription/{id}")
    public void deletePrescription(@PathVariable int id){
        prescriptionService.deletePrescription(id);
    }





}
