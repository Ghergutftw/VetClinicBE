package App.Service;

import App.Entity.Consultation;
import App.Entity.WorkingHours;
import App.Repository.AnimalRepository;
import App.Repository.ConsultationRepository;
import App.Repository.WorkingHoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;
@Service
public class ConsultationServiceImp implements ConsultationService {
   private final ConsultationRepository consultationRepository;
   private final WorkingHoursRepository workingHoursRepository;
    private final AnimalRepository animalRepository;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository consultationRepository, WorkingHoursRepository workingHoursRepository, AnimalRepository animalRepository) {
        this.consultationRepository = consultationRepository;
        this.workingHoursRepository = workingHoursRepository;
        this.animalRepository = animalRepository;
    }
    @Override
    public void createConsultation(Consultation consultation) {
        Calendar theCalender=Calendar.getInstance();
        theCalender.setTime(consultation.getIntendedHour());
        Calendar anotherCalender=Calendar.getInstance();
        anotherCalender.setTime(consultation.getIntendedHour());
        anotherCalender.add(Calendar.HOUR_OF_DAY,-1);
        List<WorkingHours> theWorkingHours=workingHoursRepository.getAllByStatusAndStartingHourBetween("FREE",anotherCalender.getTime(),theCalender.getTime());
        if(theWorkingHours!=null&&theWorkingHours.size()>0)
        {
            if(consultation.getAnimal()!=null){
                consultation.setAnimal(animalRepository.save(consultation.getAnimal()));
                consultation.setWorkingHours(theWorkingHours.get(0));
                consultation.getWorkingHours().setStatus("USED");
            }
            consultationRepository.save(consultation);
            System.out.println("Programat ! Pe data de " + consultation.getIntendedHour()  );
        }else {
            System.out.println("Nu se poate programa." + consultation.getIntendedHour() + " este ocupat ! " );
        }
    }

    @Override
    public List<Consultation> getConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public void deleteConsultation(int id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public void updateConsultation(Consultation consultation, int id) {
        consultation.setId(id);
        consultationRepository.save(consultation);
    }
}
