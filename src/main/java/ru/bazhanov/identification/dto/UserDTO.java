package ru.bazhanov.identification.dto;

public class UserDTO {
    String name;
    String login;
    String password;
    String role;

   public UserDTO(){
    }
    public UserDTO(String name,String login, String password, String role){
       this.name = name;
       this.login = login;
       this.password = password;
       this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
