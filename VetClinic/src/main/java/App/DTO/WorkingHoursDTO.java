package App.DTO;

import App.Entity.Doctor;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkingHoursDTO {

    private int id;
    private Date startingHour;
    private Date endingHour;
    private String status;
    private DoctorDTO doctor;



}
