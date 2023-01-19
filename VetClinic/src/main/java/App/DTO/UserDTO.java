package App.DTO;

import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String password;
    private String role;
    private String email;

}
