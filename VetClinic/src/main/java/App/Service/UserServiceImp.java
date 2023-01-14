package App.Service;

import App.Entity.User;
import App.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes())));
        userRepository.save(user);
        System.out.println("CREATED!");
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
        System.out.println("Deleted!");
    }

    @Override
    public void updateUser(User user, int id) {
        user.setId(id);
        user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes())));
        userRepository.save(user);
    }

    @Override
    public void login(User user) {
        String testingEmail=user.getEmail();
        String testingPassword=user.getPassword();
        //ca sa nu expunem parola din baza de date o criptam si pe cea cu care sa verificam astfel comparam criptat vs criptat
        //!!!! sa fie aceeasi criptare
        testingPassword=Base64.getEncoder().encodeToString(testingPassword.getBytes());
        List<User> users=userRepository.findAll();
        boolean found=false;
        for (User theUser:users) {
            if (testingEmail.equals(theUser.getEmail()) && testingPassword.equals(theUser.getPassword())) {
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("Login Successfully");
        }else{
            System.out.println("Not found");
        }
    }
    @Override
    public Optional<User> getUserById(int id) {
       return userRepository.findById(id);
    }

    @Override
    public String getDecodedPassword(String encodedPassword) {
        byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
        decodedPassword = new String(decodedPassword).getBytes();
        return new String(decodedPassword);
    }
}
