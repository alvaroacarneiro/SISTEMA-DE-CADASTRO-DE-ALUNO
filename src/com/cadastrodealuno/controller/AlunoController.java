
package com.cadastrodealuno.controller;

import com.seuprojeto.model.Aluno;
import com.seuprojeto.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public String criar(@RequestBody Aluno aluno) {
        return service.adicionar(aluno);
    }

    @GetMapping("/{matricula}")
    public Aluno buscar(@PathVariable String matricula) {
        return service.buscarPorMatricula(matricula);
    }

    @DeleteMapping("/{matricula}")
    public String deletar(@PathVariable String matricula) {
        return service.remover(matricula);
    }
}
