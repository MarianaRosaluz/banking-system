package br.rosaluz.banking.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/banking/system/user", produces="application/json")
public class UserController {

    @GetMapping
    public void create(){

    }
}