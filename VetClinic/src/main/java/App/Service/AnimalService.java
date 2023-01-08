package App.Service;

import App.Entity.Animal;
import App.Entity.Consultation;
import java.util.List;
public interface AnimalService {
    List<Animal> getAnimals();
    void addAnimal(Animal animal);
    void deleteAnimal(int id);
    void updateAnimal(Animal animal, int id);
    List<Consultation> showHistoryOfAnAnimal (int id);

    Animal getAnimalById(int id);
}
