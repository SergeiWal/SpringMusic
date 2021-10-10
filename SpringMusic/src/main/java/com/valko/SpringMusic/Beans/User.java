package com.valko.SpringMusic.Beans;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Size(min = 4, max = 32, message = "User name have length from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String name;

    @Column
    @Size(min = 4, max = 20,message = "User length: from 4 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private String login;

    @Column
    @Size(min=8, max = 32, message="Password must be from 8 to 32 symbols")
    @NotNull(message = "Cannot be null")
    private long password;

    @Column
    @NotNull(message = "Cannot be null")
    private boolean isAdmin;

    public User(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
