package Controller;

import Model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping (value = "/")
    public String getUsers(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("user",new User());
        return "users";
    }
    @GetMapping("/editUserPage/{id}")
    public String editUserPage(@PathVariable(required = false) Integer id,Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "editUserPage";
    }
    @PostMapping("/editUser")
    public String editUser(@ModelAttribute User user) {
        userService.edit(user);
        return "redirect:/";
    }
    @PostMapping("/addUser")
    public String addUserPage(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/";
    }
    @GetMapping("/removeUser/{id}")
    public String removeUserPage(@PathVariable int id) {
        userService.removeUser(id);
        return "redirect:/";
    }
}
