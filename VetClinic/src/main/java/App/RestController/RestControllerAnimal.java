package App.RestController;

import App.Entity.Animal;
import App.Entity.Consultation;
import App.Service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RestControllerAnimal {

    private final AnimalService animalService;

    @Autowired
    public RestControllerAnimal(AnimalService animalService) {
        this.animalService = animalService;
    }


    @GetMapping("/animals")
    public List<Animal> getAnimals(){
        return animalService.getAnimals();
    }

    @PostMapping("/animal")
    public void addAnimal(@RequestBody Animal animal){
        animalService.addAnimal(animal);
    }

    @DeleteMapping("/animals/{id}")
    public void deleteAnimal(@PathVariable int id){
        animalService.deleteAnimal(id);
    }

    @PutMapping( "/animals/{id}")
    public void updateAnimal(@RequestBody Animal animal, @PathVariable int id) {
       animalService.updateAnimal(animal,id);
    }

    @GetMapping("/animal/{id}")
    public List<Consultation> showHistoryOfAnAnimal (@PathVariable int id){
       return animalService.showHistoryOfAnAnimal(id);
    }


}
