package App.DTO;


import lombok.*;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDTO {
    private int id;

    private WorkingHoursDTO workingHours;

    private AnimalDTO animal;

    private PrescriptionDTO prescription;

    private String detectedDisease;

    private Date intendedHour;
}
