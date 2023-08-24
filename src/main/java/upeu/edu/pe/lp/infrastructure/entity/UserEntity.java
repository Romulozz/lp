package upeu.edu.pe.lp.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table (name = "usuarios")

public class UserEntity {
        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Integer id;
        private String username;
        private String firtsname;
        private String lastname;
        private String email;
        private String address;
        private String cellphone;
        private String password;
        @Enumerated(EnumType.STRING)
        private UserType userType;
        private LocalDateTime dataCreated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirtsname() {
        return firtsname;
    }

    public void setFirtsname(String firtsname) {
        this.firtsname = firtsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(LocalDateTime dataCreated) {
        this.dataCreated = dataCreated;
    }

    public UserEntity() {
    }

    public UserEntity(Integer id, String username, String firtsname, String lastname, String email, String address, String cellphone, String password, LocalDateTime dataCreated) {
        this.id = id;
        this.username = username;
        this.firtsname = firtsname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.cellphone = cellphone;
        this.password = password;
        this.dataCreated = dataCreated;
    }
}

