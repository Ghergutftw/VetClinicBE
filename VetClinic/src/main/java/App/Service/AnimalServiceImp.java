package App.Service;

import App.DTO.AnimalDTO;
import App.DTO.ConsultationDTO;
import App.Entity.Animal;
import App.Entity.Consultation;
import App.Repository.AnimalRepository;
import App.Repository.ConsultationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AnimalServiceImp implements AnimalService{

    private final AnimalRepository animalRepository;
    private final ConsultationRepository consultationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AnimalServiceImp(AnimalRepository animalRepository, ConsultationRepository consultationRepository) {
        this.animalRepository = animalRepository;
        this.consultationRepository = consultationRepository;
    }



    @Override
    public List<AnimalDTO> getAnimals() {
        List<Animal> animalListEntity = animalRepository.findAll();
        List<AnimalDTO> animalListDTO = new ArrayList<>() ;

        for (Animal animal: animalListEntity) {
            animalListDTO.add(modelMapper.map(animal,AnimalDTO.class));
        }
        return animalListDTO;
    }

    @Override
    public void addAnimal(AnimalDTO animal) {
        animalRepository.save(modelMapper.map(animal,Animal.class));
        System.out.println("ADDED!");
    }

    @Override
    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
        System.out.println("DELETED");
    }

    @Override
    public void updateAnimal(AnimalDTO animal, int id) {
        animal.setId(id);
        System.out.println("UPDATED");
        animalRepository.save(modelMapper.map(animal,Animal.class));
    }


    @Override
    public List<ConsultationDTO> showHistoryOfAnAnimal(int id) {
        List<ConsultationDTO> resultList= new ArrayList<>();
        List<Consultation> historyOfAnAnimal= consultationRepository.findAll();
        for (Consultation consultation : historyOfAnAnimal) {
            if (id == consultation.getAnimal().getId()) {
                resultList.add(modelMapper.map(consultation, ConsultationDTO.class));
            }
        }
        return  resultList;
    }

    @Override
    public AnimalDTO getAnimalById(int id) {
        Animal animalEntity = animalRepository.getAnimalById(id);
        return modelMapper.map(animalEntity,AnimalDTO.class);

    }
}
