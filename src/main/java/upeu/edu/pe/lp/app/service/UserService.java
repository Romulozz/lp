/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp.app.service;

import java.time.LocalDateTime;
import java.util.Objects;
import upeu.edu.pe.lp.app.repository.UserRepository;
import upeu.edu.pe.lp.infrastructure.entity.UserEntity;
import upeu.edu.pe.lp.infrastructure.entity.UserType;

/**
 *
 * @author Luki
 */
public class UserService {
   
private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserEntity findByUserType(UserType userType) {
        
        if (userType == UserType.USER) {
            return userRepository.findByUserType(UserType.USER);
        } else {
            return userRepository.findByUserType(UserType.ADMIN);
        }
    }
    
    public UserEntity saveUser(UserEntity user) {
                
         if (user.getId() == null){
             user.setDataCreated(LocalDateTime.now());
             user.setUserType(UserType.USER);

             return userRepository.saveUser(user);
         }else{
             UserEntity productDB = userRepository.getUserById(user.getId());
             
             return productDB;
         }
    }
/*
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
*/
}
