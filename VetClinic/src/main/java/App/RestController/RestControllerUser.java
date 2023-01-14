package App.RestController;

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
    public void createUser(@RequestBody User user){
       userService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
       userService.deleteUser(id);
    }

    @PutMapping ("/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable int id ){
       userService.updateUser(user,id);
    }

    @PutMapping("/login")
    public void login(@RequestBody User user){
        userService.login(user);
    }

    @GetMapping("/getDecoded/{encodedPassword}")
    public String getDecodedPassword(@PathVariable String encodedPassword){
        return userService.getDecodedPassword(encodedPassword);
    }


}
