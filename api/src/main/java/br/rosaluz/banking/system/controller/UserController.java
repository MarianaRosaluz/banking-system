package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.LoginDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import br.rosaluz.banking.system.service.TokenService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/login", produces="application/json")
@Api(value="API REST Banking System")
public class UserController {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authManager;

    public UserController(TokenService tokenService, AuthenticationManager authManager) {
        this.tokenService = tokenService;
        this.authManager = authManager;
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
