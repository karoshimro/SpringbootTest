package crudtest.crudtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class CRUDController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/index")
    public String index(Model model){
        List<User> users = repository.findAll();

//        User iepyon = new User();
//        iepyon.setAge(20);
//        iepyon.setName("ienaga");
//        users.add(iepyon);

        model.addAttribute("users", users);
        return "index";
    }
    @PostMapping("/index")
    public String create(@ModelAttribute User user){
        repository.save(user);
        return "redirect:/index";
    }

    @DeleteMapping("/index/{id}")
    public String delete(@PathVariable Long id){
        repository.deleteById(id);
        return "redirect:/index";
    }
}