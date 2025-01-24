package ru.bazhanov.identification.dto;

public class UserDTO {
    private int userId = 0;
    private String personName;
    private String login;
    private String password;
    private String role;

   public UserDTO(){
    }
    public UserDTO(int userId, String personName,String login, String password, String role){
       this.userId = userId;
       this.personName = personName;
       this.login = login;
       this.password = password;
       this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String name) {
        this.personName = name;
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
