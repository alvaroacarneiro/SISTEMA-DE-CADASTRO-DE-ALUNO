package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    // Banco de dados em memória
    private final List<Aluno> alunos = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // --- ENDPOINTS ---

    // Raiz
    @GetMapping("/")
    public String home() {
        return "Bem-vindo! Acesse /alunos ou /teste";
    }

    // Teste
    @GetMapping("/teste")
    public String teste() {
        return "API funcionando! 🚀";
    }

    // Listar todos os alunos
    @GetMapping("/alunos")
    public List<Aluno> listar() {
        return alunos;
    }

    // Cadastrar aluno
    @PostMapping("/alunos")
    public String cadastrar(@RequestBody Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                return "Erro: Matrícula já existe!";
            }
        }
        alunos.add(aluno);
        return "Aluno " + aluno.getNome() + " cadastrado com sucesso!";
    }

    // Buscar por matrícula
    @GetMapping("/alunos/{matricula}")
    public Aluno buscar(@PathVariable String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    // Deletar por matrícula
    @DeleteMapping("/alunos/{matricula}")
    public String deletar(@PathVariable String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                alunos.remove(a);
                return "Aluno removido com sucesso!";
            }
        }
        return "Aluno não encontrado!";
    }

    // --- CLASSE ALUNO (inner) ---
    static class Aluno {
        private String matricula;
        private String nome;
        private double nota1;
        private double nota2;
        private double nota3;

        // Construtor vazio (obrigatório para o Spring)
        public Aluno() {}

        public Aluno(String matricula, String nome, double nota1, double nota2, double nota3) {
            this.matricula = matricula;
            this.nome = nome;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.nota3 = nota3;
        }

        // Getters e Setters (obrigatórios)
        public String getMatricula() { return matricula; }
        public void setMatricula(String matricula) { this.matricula = matricula; }

        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }

        public double getNota1() { return nota1; }
        public void setNota1(double nota1) { this.nota1 = nota1; }

        public double getNota2() { return nota2; }
        public void setNota2(double nota2) { this.nota2 = nota2; }

        public double getNota3() { return nota3; }
        public void setNota3(double nota3) { this.nota3 = nota3; }
    }
}
