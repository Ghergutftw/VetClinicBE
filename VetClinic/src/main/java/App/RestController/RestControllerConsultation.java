package App.RestController;

import App.DTO.ConsultationDTO;
import App.Entity.Consultation;
import App.Service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class RestControllerConsultation {

    private final ConsultationService consultationService;

     @Autowired
    public RestControllerConsultation(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping("/consultation")
    public void createConsultation(@RequestBody ConsultationDTO consultation){
       consultationService.createConsultation(consultation);
    }

    @GetMapping("/consultations")
    public List<ConsultationDTO> getConsultations(){
        return consultationService.getConsultations();
    }

    @DeleteMapping("/consultation/{id}")
    public void deleteConsultation(@PathVariable int id){
        consultationService.deleteConsultation(id);
    }

    @PutMapping("/consultations/{id}")
    public void updateConsultation(@RequestBody ConsultationDTO consultation,@PathVariable int id)
    {
        consultationService.updateConsultation(consultation,id);
    }


}
