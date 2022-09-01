package App.RestController;

import App.Entity.User;
import App.Service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class RestControllerUser {
    private UserService userService;

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


}
