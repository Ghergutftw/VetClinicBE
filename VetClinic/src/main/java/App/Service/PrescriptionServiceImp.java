package App.Service;

import App.Entity.Consultation;
import App.Entity.Prescription;
import App.Prescription.DiseaseTreatment;
import App.Repository.ConsultationRepository;
import App.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class  PrescriptionServiceImp implements PrescriptionService{
    private final  ConsultationRepository consultationRepository;
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PrescriptionServiceImp(ConsultationRepository consultationRepository, PrescriptionRepository prescriptionRepository) {
        this.consultationRepository = consultationRepository;
        this.prescriptionRepository = prescriptionRepository;
    }
    @Override
    public void getPrescription(int id) {
        Optional<Consultation> theConsultation= consultationRepository.findById(id);
        String theDisease=theConsultation.get().getDetectedDisease();
        String theTreatment= new DiseaseTreatment().getBook().get(theDisease);
        Prescription thePrescription=new Prescription();
        thePrescription.setTreatment(theTreatment);
        thePrescription = prescriptionRepository.save(thePrescription);
        theConsultation.get().setPrescription(thePrescription);
        consultationRepository.save(theConsultation.get());
        System.out.println("Animalul " + theConsultation.get().getAnimal().getNickname() + " are tratementul " + theTreatment);

    }

    @Override
    public List<Prescription> showAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    @Override
    public void deletePrescription(int id) {
        prescriptionRepository.deleteById(id);
    }
}
