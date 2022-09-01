package App.Service;

import App.Entity.User;
import java.util.List;
public interface UserService {
    void createUser(User user);
    List<User> getUsers();
    void deleteUser(int id);
    void updateUser(User user,int id);
    void login(User user);
}
