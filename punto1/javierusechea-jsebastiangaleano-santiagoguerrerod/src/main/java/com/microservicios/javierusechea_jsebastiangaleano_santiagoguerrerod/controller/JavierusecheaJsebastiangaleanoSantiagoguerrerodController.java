package com.microservicios.javierusechea_jsebastiangaleano_santiagoguerrerod.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/myservice")
public class JavierusecheaJsebastiangaleanoSantiagoguerrerodController {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("javierusechea", "Javier Useche");
        users.put("jsebastiangaleano", "Sebastián Galeano");
        users.put("santiagoguerrerod", "Santiago Guerrero");
    }

    @GetMapping("/nombre/{usuario}")
    public ResponseEntity<String> getUserFullName(@PathVariable("usuario") String usuario) {

        String fullName = users.get(usuario.toLowerCase());

        if (fullName != null) {
            return ResponseEntity.ok(fullName);
        } else {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
    }
}
