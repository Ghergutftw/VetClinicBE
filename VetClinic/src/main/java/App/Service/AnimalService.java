package App.Service;

import App.DTO.AnimalDTO;
import App.DTO.ConsultationDTO;
import App.Entity.Animal;
import App.Entity.Consultation;
import java.util.List;
public interface AnimalService {
    List<AnimalDTO> getAnimals();
    void addAnimal(AnimalDTO animal);
    void deleteAnimal(int id);
    void updateAnimal(AnimalDTO animal, int id);
    List<ConsultationDTO> showHistoryOfAnAnimal (int id);
    AnimalDTO getAnimalById(int id);
}
