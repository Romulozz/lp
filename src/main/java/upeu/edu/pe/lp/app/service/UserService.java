/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.app.service;

import java.util.Objects;
import upeu.edu.pe.lp.app.repository.UserRepository;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

/**
 *
 * @author Luki
 */
public class UserService {
   
private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserEntity findByEmail(String email) {
        
        UserEntity existingUser = userRepository.findByEmail(email);
        
            if(existingUser.getEmail().equals(email)){
                return null;
            }else{
                return userRepository.findByEmail(email);
            }
    }
    
    public UserEntity saveUser(UserEntity user) {
        UserEntity existingUser = userRepository.findByEmail(user.getEmail());
        
         if (user.getId() == null){
          /*
             existingUser.setId(1);
             existingUser.setAddress(address);
             existingUser.setCellphone(cellphone);
             existingUser.setDataCreated(LocalDateTime.now());
             existingUser.setEmail(email);
             existingUser.setFirtsname(firtsname);
             existingUser.setLastname(lastname);
             existingUser.setPassword(password);
             existingUser.setUsername(username);
         */
             return userRepository.saveUser(existingUser);
         }else{
             UserEntity productDB = userRepository.getUserById(user.getId());
             
             return productDB;
         }
    }

    public UserEntity updateUser(UserEntity user) {
        UserEntity userExists = new UserEntity();
        if (!Objects.equals(user.getId(), userExists)) {
           userExists.setUsername(user.getUsername());
            userExists.setEmail(user.getEmail());
            // Actualiza otros campos según tus necesidades
            return userExists;
        }
        return null; // Devolver null si no se encuentra el usuario
    }

    public void deleteUserById(Integer id) {
       userRepository.deleteUserById(id);
    }    
}
