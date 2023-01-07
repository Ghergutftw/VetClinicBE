package App.Repository;

import App.Entity.Consultation;
import App.Entity.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {

    void deleteAllByWorkingHours(WorkingHours workingHours);

}
