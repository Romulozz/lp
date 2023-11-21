/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @author Luki
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    
    private final Logger log = LoggerFactory.getLogger(ProductoController.class);
    private final UserService userService;

    public RegisterController(UserService userService) {

        this.userService = userService;
    }
    
    @GetMapping
    public String showRegisterForm() {     

        return "login/register"; // Renderiza la página de registro (register.html)
    }

}
