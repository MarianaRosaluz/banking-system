package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.User;

public class UserResponseDto {

    public String name;

    public String login;

    public UserResponseDto(User user) {

        this.name = user.getName();
        this.login = user.getLogin();
    }

}
