package App.Service;

import App.DTO.AnimalDTO;
import App.DTO.ConsultationDTO;
import App.DTO.WorkingHoursDTO;
import App.Entity.Consultation;
import App.Entity.Animal;
import App.Entity.WorkingHours;
import App.Repository.AnimalRepository;
import App.Repository.ConsultationRepository;
import App.Repository.WorkingHoursRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Service
public class ConsultationServiceImp implements ConsultationService {
   private final ConsultationRepository consultationRepository;
   private final WorkingHoursRepository workingHoursRepository;
    private final AnimalRepository animalRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public ConsultationServiceImp(ConsultationRepository consultationRepository, WorkingHoursRepository workingHoursRepository, AnimalRepository animalRepository, ModelMapper modelMapper) {
        this.consultationRepository = consultationRepository;
        this.workingHoursRepository = workingHoursRepository;
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public void createConsultation(ConsultationDTO consultation) {
        Calendar theCalender=Calendar.getInstance();
        theCalender.setTime(consultation.getIntendedHour());
        Calendar anotherCalender=Calendar.getInstance();
        anotherCalender.setTime(consultation.getIntendedHour());
        anotherCalender.add(Calendar.HOUR_OF_DAY,-1);
        List<WorkingHours> theWorkingHours=workingHoursRepository.getAllByStatusAndStartingHourBetween("FREE",anotherCalender.getTime(),theCalender.getTime());
        if(theWorkingHours!=null&&theWorkingHours.size()>0)
        {
            if(consultation.getAnimal()!=null){
                consultation.setAnimal(modelMapper.map(animalRepository.save(modelMapper.map(consultation,Consultation.class).getAnimal()),ConsultationDTO.class).getAnimal());
                consultation.setWorkingHours(modelMapper.map(theWorkingHours.get(0),WorkingHoursDTO.class));
                consultation.getWorkingHours().setStatus("USED");
            }
            assert consultation.getAnimal() != null;
            consultation.getAnimal().setSpecie(consultation.getAnimal().getSpecie());
            consultationRepository.save(modelMapper.map(consultation,Consultation.class));
            System.out.println("Programat ! Pe data de " + consultation.getIntendedHour()  );
        }else {
            System.out.println("Nu se poate programa." + consultation.getIntendedHour() + " este ocupat ! " );
        }
    }

    @Override
    public List<ConsultationDTO> getConsultations() {
        List<ConsultationDTO> consultationDTOList = new ArrayList<>();
        List<Consultation> consultationList = consultationRepository.findAll();
        for (Consultation consultation:consultationList) {
            consultationDTOList.add(modelMapper.map(consultation,ConsultationDTO.class));
        }
        return consultationDTOList;
    }

    @Override
    public void deleteConsultation(int id) {
        consultationRepository.deleteById(id);
    }

    @Override
    public void updateConsultation(ConsultationDTO consultation, int id) {
        consultation.setId(id);
        consultationRepository.save(modelMapper.map(consultation,Consultation.class));
    }
}
