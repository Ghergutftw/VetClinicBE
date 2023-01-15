package App.Service;

import App.Entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(User user);
    List<User> getUsers();
    void deleteUser(int id);
    void updateUser(User user,int id);
    void login(User user);
    Optional<User> getUserById(int id);
    String getDecodedPassword(String encodedPassword);
    String getEncodedPassword(String decodedPassword);
}
