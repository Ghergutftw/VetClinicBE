package App.DTO;

import App.Entity.User;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {
    private int id;
    private String firstName;
    private String lastName;
    private User user;
    private String speciality;
    private int age;
    private int yearsOfExperience;
}
