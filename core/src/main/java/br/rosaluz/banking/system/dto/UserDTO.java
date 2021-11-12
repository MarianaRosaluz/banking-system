package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.User;

import java.util.Date;

public class UserDTO {

    private  String name;
    private String document;
    private Date birthDate;
    private String motherName;
    private  String  login;
    private String  password;



    public UserDTO(String name, String document, Date birthDate, String motherName, String login, String password) {
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.motherName = motherName;
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public User convertToUser(){
        return  new User(name,document,birthDate, motherName, login,password);
    }
}
