package pl.softserve.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.softserve.Models.User;
import pl.softserve.Services.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
    public String getCustomers(Model model){
        List<User> listOfCustomers = userService.getAllUsers();
        model.addAttribute("customer", new User());
        model.addAttribute("listOfCustomers", listOfCustomers);
        return "customerOrderDetails";
    }
}
