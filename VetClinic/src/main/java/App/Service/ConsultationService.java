package App.Service;

import App.DTO.ConsultationDTO;
import App.Entity.Consultation;
import java.util.List;
public interface ConsultationService {
    void createConsultation(ConsultationDTO consultation);
    List<ConsultationDTO> getConsultations();
    void deleteConsultation(int id);
    void updateConsultation(ConsultationDTO consultation,int id);
}
