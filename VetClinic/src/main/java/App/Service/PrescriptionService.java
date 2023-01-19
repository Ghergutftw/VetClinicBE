package App.Service;

import App.DTO.PrescriptionDTO;
import App.Entity.Prescription;
import java.util.List;
public interface PrescriptionService {
    void getPrescription(int id);
    List<PrescriptionDTO> showAllPrescriptions();
    void deletePrescription(int id);
}
