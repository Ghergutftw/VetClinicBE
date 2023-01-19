package App.Service;

import App.DTO.UserDTO;
import App.Entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(UserDTO user);
    List<UserDTO> getUsers();
    void deleteUser(int id);
    void updateUser(UserDTO user,int id);
    void login(UserDTO user);
    Optional<UserDTO> getUserById(int id);
    String getDecodedPassword(String encodedPassword);
    String getEncodedPassword(String decodedPassword);
}
