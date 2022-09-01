package App.Repository;

import App.Entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {
}
