package App.Repository;

import App.DTO.AnimalDTO;
import App.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnimalRepository extends JpaRepository<Animal,Integer> {

    Animal getAnimalById(int id);

}
