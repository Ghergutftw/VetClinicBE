package App.DTO;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDTO {
    private int id;
    private String nickname;
    private String animalType;
    private String specie;
    private int age;
    private double weight;
}
