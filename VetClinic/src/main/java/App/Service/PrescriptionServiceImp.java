package App.Service;

import App.DTO.ConsultationDTO;
import App.DTO.PrescriptionDTO;
import App.Entity.Consultation;
import App.Entity.Prescription;
import App.Prescription.DiseaseTreatment;
import App.Repository.ConsultationRepository;
import App.Repository.PrescriptionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class  PrescriptionServiceImp implements PrescriptionService{
    private final  ConsultationRepository consultationRepository;
    private final PrescriptionRepository prescriptionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public PrescriptionServiceImp(ConsultationRepository consultationRepository, PrescriptionRepository prescriptionRepository) {
        this.consultationRepository = consultationRepository;
        this.prescriptionRepository = prescriptionRepository;
    }
    @Override
    public void getPrescription(int id) {
        Optional<ConsultationDTO> theConsultation= Optional.ofNullable(modelMapper.map(consultationRepository.findById(id), ConsultationDTO.class));
        String theDisease=theConsultation.get().getDetectedDisease();
        String theTreatment= new DiseaseTreatment().getBook().get(theDisease);
        Prescription thePrescription=new Prescription();
        thePrescription.setTreatment(theTreatment);
        thePrescription = prescriptionRepository.save(thePrescription);
        theConsultation.get().setPrescription(modelMapper.map(thePrescription,PrescriptionDTO.class));
        consultationRepository.save(modelMapper.map(theConsultation.get(),Consultation.class));
        System.out.println("Animalul " + theConsultation.get().getAnimal().getNickname() + " are tratementul " + theTreatment);
    }

    @Override
    public List<PrescriptionDTO> showAllPrescriptions() {
        ArrayList<Prescription> arrayList = (ArrayList<Prescription>) prescriptionRepository.findAll();
        ArrayList<PrescriptionDTO> prescriptionDTOArrayList = new ArrayList<>();
        for (Prescription value: arrayList) {
            prescriptionDTOArrayList.add(modelMapper.map(value,PrescriptionDTO.class));
        }
        return prescriptionDTOArrayList;
    }

    @Override
    public void deletePrescription(int id) {
        prescriptionRepository.deleteById(id);
    }
}
