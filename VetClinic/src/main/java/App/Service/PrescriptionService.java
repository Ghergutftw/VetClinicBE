package App.Service;

import App.Entity.Prescription;
import java.util.List;
public interface PrescriptionService {
    void getPrescription(int id);
    List<Prescription> showAllPrescriptions();
    void deletePrescription(int id);
}
