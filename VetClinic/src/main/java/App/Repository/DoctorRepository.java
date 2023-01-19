package App.Repository;


import App.DTO.DoctorDTO;
import App.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Doctor getDoctorById(int id);
}


