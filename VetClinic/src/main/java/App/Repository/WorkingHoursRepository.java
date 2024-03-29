package App.Repository;

import App.DTO.WorkingHoursDTO;
import App.Entity.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
@Repository
public interface WorkingHoursRepository extends JpaRepository<WorkingHours,Integer> {
    List<WorkingHours> getAllByStatusAndStartingHourBetween(String free, Date time, Date time1);

    void deleteAllByDoctor_Id(int id);

    List<WorkingHours> getAllByDoctor_Id(int id);
}
