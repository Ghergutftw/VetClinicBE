package App.RestController;

import App.DTO.AnimalDTO;
import App.DTO.ConsultationDTO;
import App.Entity.Animal;
import App.Entity.Consultation;
import App.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class RestControllerAnimal {

    private final AnimalService animalService;

    @Autowired
    public RestControllerAnimal(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/animals")
    public List<AnimalDTO> getAnimals(){
        return animalService.getAnimals();
    }

    @PostMapping("/animal")
    public void addAnimal(@RequestBody AnimalDTO animal){
        animalService.addAnimal(animal);
    }

    @DeleteMapping("/animals/{id}")
    public void deleteAnimal(@PathVariable int id){
        animalService.deleteAnimal(id);
    }

    @PutMapping( "/animals/{id}")
    public void updateAnimal(@RequestBody AnimalDTO animal, @PathVariable int id) {
       animalService.updateAnimal(animal,id);
    }

    @GetMapping("/animal/{id}")
    public List<ConsultationDTO> showHistoryOfAnAnimal (@PathVariable int id){
       return animalService.showHistoryOfAnAnimal(id);
    }

    @GetMapping("/animal-id/{id}")
    public AnimalDTO getAnimalById(@PathVariable int id){
        return animalService.getAnimalById(id);
    }


}
