package App.RestController;

import App.DTO.UserDTO;
import App.Entity.User;
import App.Service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class RestControllerUser {
    private final UserService userService;

    public RestControllerUser(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO user){
       userService.createUser(user);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<UserDTO> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
       userService.deleteUser(id);
    }

    @PutMapping ("/user/{id}")
    public void updateUser(@RequestBody UserDTO user, @PathVariable int id ){
       userService.updateUser(user,id);
    }

    @PutMapping("/login")
    public void login(@RequestBody UserDTO user){
        userService.login(user);
    }

    @GetMapping("/getDecoded/{encodedPassword}")
    public Optional<String> getDecodedPassword(@PathVariable String encodedPassword){
        return Optional.ofNullable(userService.getDecodedPassword(encodedPassword));
    }

    @GetMapping("/getEncoded/{decodedPassword}")
    public Optional<String> getEncodedPassword(@PathVariable String decodedPassword){
        return Optional.ofNullable(userService.getEncodedPassword(decodedPassword));
    }




}
