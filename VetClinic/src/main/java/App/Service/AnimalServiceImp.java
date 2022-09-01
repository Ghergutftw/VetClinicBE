package App.Service;

import App.Entity.Animal;
import App.Entity.Consultation;
import App.Repository.AnimalRepository;
import App.Repository.ConsultationRepository;
import App.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class AnimalServiceImp implements AnimalService{

    private final AnimalRepository animalRepository;
    private final ConsultationRepository consultationRepository;
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public AnimalServiceImp(AnimalRepository animalRepository, ConsultationRepository consultationRepository, PrescriptionRepository prescriptionRepository) {
        this.animalRepository = animalRepository;
        this.consultationRepository = consultationRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalRepository.save(animal);
        System.out.println("ADDED!");
    }

    @Override
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
        System.out.println("DELETED");
    }

    @Override
    public void updateAnimal(Animal animal, int id) {
        animal.setId(id);
        animalRepository.save(animal);
        System.out.println("UPDATED");
    }


    @Override
    public List<Consultation> showHistoryOfAnAnimal(int id) {
        List<Consultation> resultList= new ArrayList<>();
        List<Consultation> historyOfAnAnimal= consultationRepository.findAll();
        for (int i = 0; i < historyOfAnAnimal.size() ; i++) {
            if(id==historyOfAnAnimal.get(i).getAnimal().getId()){
                resultList.add(historyOfAnAnimal.get(i));
            }
        }
        return  resultList;
    }
}
