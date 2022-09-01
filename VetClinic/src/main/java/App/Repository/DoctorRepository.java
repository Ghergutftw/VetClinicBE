package App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import App.Entity.Doctor;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
}


