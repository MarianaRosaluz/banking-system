package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.UserDTO;
import br.rosaluz.banking.system.dto.UserResponseDto;
import br.rosaluz.banking.system.model.User;
import br.rosaluz.banking.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value = "/api/banking/system/user", produces="application/json")
public class UserController {

    @Autowired
    private UserService userService;
    private ConversionService conversionService;


    public UserController(UserService userService, ConversionService conversionService) {

        this.userService = userService;
        this.conversionService = conversionService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriBuider)
    {
        //TODO Validar se login já existe
         User user = userService.saveUser(userDTO.convertToUser());

        URI uri = uriBuider.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserResponseDto(user));

    }
}
