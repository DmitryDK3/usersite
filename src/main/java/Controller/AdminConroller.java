package Controller;

import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Model.User;

import Model.Role;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminConroller {
    @Autowired
    private UserService userService;

    @GetMapping (value = "")
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
        return "redirect:/admin";
    }

    @PostMapping("/addUser")
    public String addUserPage(@ModelAttribute User user) {
        Set<Role> set = new HashSet<>(user.getRoles());
        set.stream().forEach(System.out::println);
        userService.addUser(user);
        return "redirect:/admin";
    }
    @GetMapping("/removeUser/{id}")
    public String removeUserPage(@PathVariable int id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

}
