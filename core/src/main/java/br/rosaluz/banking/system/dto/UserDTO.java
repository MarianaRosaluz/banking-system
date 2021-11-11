package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.User;

public class UserDTO {

    private  String name;



    private  String  login;
    private String  password;

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    public UserDTO(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User convertToUser(){
        return  new User(name,login, password);
    }
}
