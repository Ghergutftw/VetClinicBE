package App.Service;

import App.DTO.UserDTO;
import App.Entity.User;
import App.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO user) {
        user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes())));
        userRepository.save(modelMapper.map(user,User.class));
        System.out.println("CREATED!");
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User user:userList) {
            userDTOList.add(modelMapper.map(user, UserDTO.class));
        }
        return userDTOList;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
        System.out.println("Deleted!");
    }

    @Override
    public void updateUser(UserDTO user, int id) {
        user.setId(id);
        user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes())));
        userRepository.save(modelMapper.map(user,User.class));
    }

    @Override
    public void login(UserDTO user) {
        String testingEmail=user.getEmail();
        String testingPassword=user.getPassword();
        //ca sa nu expunem parola din baza de date o criptam si pe cea cu care sa verificam astfel comparam criptat vs criptat
        //!!!! sa fie aceeasi criptare
        testingPassword=Base64.getEncoder().encodeToString(testingPassword.getBytes());
        List<User> users=userRepository.findAll();
        List<UserDTO> userDTOList=new ArrayList<>();
        for (User user1: users) {
            userDTOList.add(modelMapper.map(user1,UserDTO.class));
        }
        boolean found=false;
        for (UserDTO theUser:userDTOList) {
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
    public Optional<UserDTO> getUserById(int id) {
        return Optional.ofNullable(modelMapper.map(userRepository.findById(id), UserDTO.class));
    }

    @Override
    public String getDecodedPassword(String encodedPassword) {
        byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
        decodedPassword = new String(decodedPassword).getBytes();
        return new String(decodedPassword);
    }

    @Override
    public String getEncodedPassword(String decodedPassword) {
        return Base64.getEncoder().encodeToString(decodedPassword.getBytes());
    }
}
