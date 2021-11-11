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
@RequestMapping(value = "/api/banking/system/user", produces="application/json")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private  PasswordEncoder encoder;


    public UserController(UserService userService,AuthenticationManager authManager, TokenService tokenService,PasswordEncoder encoder) {

        this.encoder = encoder;
        this.authManager = authManager;
        this.userService = userService;
        this.tokenService = tokenService;
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

    @PostMapping("/auth")
    public ResponseEntity<TokenDto> authenticator(@RequestBody @Valid LoginDTO loginDTO)
    {
        UsernamePasswordAuthenticationToken dataLogin = loginDTO.converter();

        try{
            Authentication authentication = authManager.authenticate(dataLogin);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new TokenDto(token,"Bearer"));

        }catch (AuthenticationException e){
           //TODO RETORNAR MENSAGEM CERTA DE ERRO NO USUARIO OU SENHA
            return ResponseEntity.badRequest().build();
        }
    }

}
