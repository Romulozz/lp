/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp.app.repository;

import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

/**
 *
 * @author Luki
 */
public interface UserRepository {
    
    UserEntity findById(Integer id);
    UserEntity findByemail(String email);
    UserEntity saveUser(UserEntity user);
    //UserEntity updateUser(UserEntity user);
    //void deleteUserById(Integer id);
}
