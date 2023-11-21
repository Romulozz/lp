package upeu.edu.pe.lp.app.service;

import upeu.edu.pe.lp.infrastructure.entity.UserEntity;

public class RegistrationService {
    private final UserService userServices;

    // private final PasswordEncoder passwordEncoder;


    public RegistrationService(UserService userServices) {
        this.userServices = userServices;
    }

    public void register(UserEntity user){
       // user.setPassword(passwordEncoder.encode(user.getPassword()));

        userServices.saveUser(user);
    }
}
