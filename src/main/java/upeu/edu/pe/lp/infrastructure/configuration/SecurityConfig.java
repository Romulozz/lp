package upeu.edu.pe.lp.infrastructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import upeu.edu.pe.lp.infrastructure.service.UserDetailServiceImpl;
import upeu.edu.pe.lp.infrastructure.service.loginHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailServiceImpl userDetailService;

    @Autowired
    private loginHandler loginHandler;
    public SecurityConfig(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }
    //metodo de autentificación
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/admin/").hasRole("ADMIN")
                        .requestMatchers("/user/").hasRole("USER")
                        .requestMatchers("/login", "/register", "/css/", "/js/", "/images/").permitAll()
                        .anyRequest().authenticated() // 👈 Esto activa protección para rutas como /home
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(loginHandler) // 👈 Tu handler personalizado
                        .permitAll()
                )
                .logout(log -> log
                        .logoutSuccessUrl("/login?logout") // 👈 Redirige al login con parámetro
                        .permitAll()
                )
                .build();
    }


    //metodo para encriptar las contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }





}
