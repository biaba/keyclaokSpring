package com.keycloak.controllers;

import com.keycloak.entities.ComputerPart;
import com.keycloak.repositories.ComputerPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
public class WebController {

    @Autowired
    private ComputerPartRepository cpRepo;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/";
    }

    @GetMapping(path = "/computerparts")
    public List<ComputerPart> computerParts() {
        return cpRepo.findAll();
    }

}
