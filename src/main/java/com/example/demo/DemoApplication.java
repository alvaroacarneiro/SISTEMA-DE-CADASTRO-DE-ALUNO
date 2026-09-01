package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Isso transforma a própria classe principal em um Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ENDPOINT DE TESTE - vai funcionar com certeza!
    @GetMapping("/teste")
    public String teste() {
        return "A API está no ar! 🚀";
    }

    // Endpoint raiz para não dar mais Whitelabel
    @GetMapping("/")
    public String home() {
        return "Bem-vindo! Acesse /alunos ou /teste";
    }
}
