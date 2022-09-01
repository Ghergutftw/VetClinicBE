package App.Service;

import App.Entity.Consultation;
import java.util.List;
public interface ConsultationService {
    void createConsultation(Consultation consultation);
    List<Consultation> getConsultations();
    void deleteConsultation(int id);
    void updateConsultation(Consultation consultation,int id);
}
