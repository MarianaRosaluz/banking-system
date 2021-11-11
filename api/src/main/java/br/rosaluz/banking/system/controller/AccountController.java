package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.*;
import br.rosaluz.banking.system.model.User;
import br.rosaluz.banking.system.service.TokenService;
import br.rosaluz.banking.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value = "/api/banking/system/singup", produces="application/json")
public class AccountController {

    @Autowired
    private UserService userService;
    @Autowired
    private  PasswordEncoder encoder;


    public AccountController(UserService userService, PasswordEncoder encoder) {

        this.encoder = encoder;
        this.userService = userService;
    }

    @GetMapping("/checkAvailableSigninName")
    public ResponseEntity<?> checkAvailableSigninName(@RequestBody @Valid SingInName singInName)
    {
        boolean valid = userService.validateLoginAlredyExist(singInName);
        return ResponseEntity.ok(new UserResponseDto(valid));

    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriBuider)
    {

        //TODO MUDAR FORMA DE CODIFICAR
         userDTO.setPassword(encoder.encode(userDTO.getPassword()));
         User user = userService.saveUser(userDTO.convertToUser());

        URI uri = uriBuider.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
