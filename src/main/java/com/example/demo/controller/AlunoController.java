package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

@GetMapping("/")
public String home() {
    return "Bem-vindo à API de Cadastro de Alunos! Acesse /alunos para listar os cadastrados.";
}
    
    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody Aluno aluno) {
        String resultado = service.adicionar(aluno);
        if (resultado.startsWith("Erro")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> buscar(@PathVariable String matricula) {
        Aluno aluno = service.buscarPorMatricula(matricula);
        if (aluno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<String> deletar(@PathVariable String matricula) {
        String resultado = service.remover(matricula);
        if (resultado.contains("não encontrada")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
        return ResponseEntity.ok(resultado);
    }
}
