package ma.um6.monhopital.web;

import ma.um6.monhopital.entities.Patient;
import ma.um6.monhopital.security.entities.AppUser;
import ma.um6.monhopital.security.repositories.AppUserRepository;
import ma.um6.monhopital.security.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class LoginController {
    AppUserRepository appUserRepository;
    @Autowired
    SecurityService securityService;
    @GetMapping("/login")
    public String login(){
        return "connexion/login";
    }
    @GetMapping("/logout")
    public String logout(){
        return  "redirect:/login";
    }


    @GetMapping(path = "/register")
    public String formUser(Model model,String username, String password){
        model.addAttribute("username",username);
        model.addAttribute("password",password);
        return "connexion/register";
    }
    @PostMapping(path = "/register/newUser")
    public String save(Model model , String username, String password, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formUser";

            System.out.println(username);
            securityService.saveNewUser(username,password,password);
            return "redirect:/login";


    }


}
