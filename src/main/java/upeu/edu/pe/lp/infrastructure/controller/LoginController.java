/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp.app.service.UserService;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public String showLoginForm(){
        return "login/login";
    }
    
    @PostMapping("")
    public String LoginUser(@ModelAttribute("loginForm") UserEntity loginForm, Model model){
     /*
        UserEntity user = new UserEntity();
        user.setUserType(UserType.USER);
        model.addAttribute("user", user);
        
        if(!userService.findByUserType(user.getUserType())){
            return "redirect:/home";
        }else{
            return "redirect:/admin";
        }              
        */
     return "redirect:/home";
    }
}
