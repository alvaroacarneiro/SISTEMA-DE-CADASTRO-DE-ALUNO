package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos", description = "Endpoints para gerenciamento de alunos")
public class DemoApplication {

    // Banco de dados em memória
    private final List<Aluno> alunos = new ArrayList<>();

    // Construtor com dados iniciais
    public DemoApplication() {
        alunos.add(new Aluno("2024001", "João Silva", 8.5, 7.0, 9.0));
        alunos.add(new Aluno("2024002", "Maria Oliveira", 9.0, 8.5, 9.5));
        alunos.add(new Aluno("2024003", "Carlos Souza", 6.0, 5.5, 7.0));
        alunos.add(new Aluno("2024004", "Ana Paula", 10.0, 9.5, 9.0));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // ========== ENDPOINTS ==========

    @Operation(summary = "Lista todos os alunos")
    @GetMapping
    public ResponseEntity<List<Aluno>> listar() {
        return ResponseEntity.ok(alunos);
    }

    @Operation(summary = "Busca um aluno por matrícula")
    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> buscar(@PathVariable String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        return ResponseEntity.ok(aluno);
    }

    @Operation(summary = "Cadastra um novo aluno")
    @PostMapping
    public ResponseEntity<Aluno> cadastrar(@Valid @RequestBody Aluno aluno) {
        // Verifica duplicidade
        if (alunos.stream().anyMatch(a -> a.getMatricula().equals(aluno.getMatricula()))) {
            throw new IllegalArgumentException("Matrícula " + aluno.getMatricula() + " já existe!");
        }
        alunos.add(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @Operation(summary = "Atualiza um aluno existente")
    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> atualizar(
            @PathVariable String matricula,
            @Valid @RequestBody Aluno alunoAtualizado) {
        Aluno existente = buscarPorMatricula(matricula);
        existente.setNome(alunoAtualizado.getNome());
        existente.setNota1(alunoAtualizado.getNota1());
        existente.setNota2(alunoAtualizado.getNota2());
        existente.setNota3(alunoAtualizado.getNota3());
        return ResponseEntity.ok(existente);
    }

    @Operation(summary = "Remove um aluno por matrícula")
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletar(@PathVariable String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        alunos.remove(aluno);
        return ResponseEntity.noContent().build();
    }

    // Endpoint raiz com página HTML bonita
    @GetMapping("/")
    @Operation(hidden = true)
    public String home() {
        return "<!DOCTYPE html>\n" +
               "<html>\n" +
               "<head>\n" +
               "  <meta charset='UTF-8'>\n" +
               "  <title>API de Cadastro de Alunos</title>\n" +
               "  <style>\n" +
               "    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; text-align: center; margin-top: 60px; background: #f0f4f8; }\n" +
               "    .container { background: white; max-width: 750px; margin: 0 auto; padding: 40px; border-radius: 16px; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }\n" +
               "    h1 { color: #2c3e50; font-size: 2.2em; }\n" +
               "    .emoji { font-size: 3em; }\n" +
               "    .endpoint { background: #ecf0f1; padding: 10px; margin: 8px 0; border-radius: 8px; font-family: monospace; display: flex; justify-content: space-between; align-items: center; }\n" +
               "    .method { display: inline-block; padding: 2px 10px; border-radius: 4px; font-weight: bold; font-size: 0.8em; }\n" +
               "    .get { background: #3498db; color: white; }\n" +
               "    .post { background: #2ecc71; color: white; }\n" +
               "    .put { background: #f39c12; color: white; }\n" +
               "    .delete { background: #e74c3c; color: white; }\n" +
               "    .badge { display: inline-block; background: #2ecc71; color: white; padding: 4px 12px; border-radius: 20px; font-size: 0.8em; }\n" +
               "    a { color: #3498db; text-decoration: none; font-weight: bold; }\n" +
               "    a:hover { text-decoration: underline; }\n" +
               "    .footer { margin-top: 30px; font-size: 0.9em; color: #7f8c8d; }\n" +
               "    .swagger-link { background: #1a1a2e; color: white; padding: 12px 24px; border-radius: 8px; display: inline-block; margin-top: 15px; text-decoration: none; }\n" +
               "    .swagger-link:hover { background: #16213e; text-decoration: none; }\n" +
               "  </style>\n" +
               "</head>\n" +
               "<body>\n" +
               "  <div class='container'>\n" +
               "    <div class='emoji'>📚</div>\n" +
               "    <h1>API de Cadastro de Alunos</h1>\n" +
               "    <p style='color: #555;'>Sistema de gerenciamento acadêmico <span class='badge'>v2.0</span></p>\n" +
               "    <div style='text-align: left; margin: 25px 0;'>\n" +
               "      <div class='endpoint'><span><span class='method get'>GET</span> /alunos → Lista todos</span> <span style='color:#7f8c8d;font-size:0.8em;'>✅</span></div>\n" +
               "      <div class='endpoint'><span><span class='method post'>POST</span> /alunos → Cadastra novo</span> <span style='color:#7f8c8d;font-size:0.8em;'>➕</span></div>\n" +
               "      <div class='endpoint'><span><span class='method get'>GET</span> /alunos/{matricula} → Busca por ID</span> <span style='color:#7f8c8d;font-size:0.8em;'>🔍</span></div>\n" +
               "      <div class='endpoint'><span><span class='method put'>PUT</span> /alunos/{matricula} → Atualiza</span> <span style='color:#7f8c8d;font-size:0.8em;'>✏️</span></div>\n" +
               "      <div class='endpoint'><span><span class='method delete'>DELETE</span> /alunos/{matricula} → Remove</span> <span style='color:#7f8c8d;font-size:0.8em;'>🗑️</span></div>\n" +
               "    </div>\n" +
               "    <a href='/swagger-ui/index.html' class='swagger-link'>📖 Acessar Documentação Swagger</a>\n" +
               "    <div class='footer'>\n" +
               "      <span>🔗 Repositório: <a href='https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO' target='_blank'>GitHub</a></span>\n" +
               "    </div>\n" +
               "  </div>\n" +
               "</body>\n" +
               "</html>";
    }

    // ========== MÉTODO AUXILIAR ==========

    private Aluno buscarPorMatricula(String matricula) {
        return alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst()
                .orElseThrow(() -> new AlunoNotFoundException(matricula));
    }

    // ========== CLASSES INTERNAS ==========

    // Modelo Aluno com validações
    public static class Aluno {

        @NotBlank(message = "Matrícula é obrigatória")
        private String matricula;

        @NotBlank(message = "Nome é obrigatório")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
        private String nome;

        @Min(value = 0, message = "Nota 1 não pode ser menor que 0")
        @Max(value = 10, message = "Nota 1 não pode ser maior que 10")
        private double nota1;

        @Min(value = 0, message = "Nota 2 não pode ser menor que 0")
        @Max(value = 10, message = "Nota 2 não pode ser maior que 10")
        private double nota2;

        @Min(value = 0, message = "Nota 3 não pode ser menor que 0")
        @Max(value = 10, message = "Nota 3 não pode ser maior que 10")
        private double nota3;

        // Construtor vazio (obrigatório)
        public Aluno() {}

        public Aluno(String matricula, String nome, double nota1, double nota2, double nota3) {
            this.matricula = matricula;
            this.nome = nome;
            this.nota1 = nota1;
            this.nota2 = nota2;
            this.nota3 = nota3;
        }

        // Getters e Setters
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

        // Métodos de negócio
        public double getMedia() {
            return (nota1 + nota2 + nota3) / 3.0;
        }

        public String getStatus() {
            return getMedia() >= 7.0 ? "Aprovado" : "Reprovado";
        }
    }

    // Exceção personalizada para aluno não encontrado
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class AlunoNotFoundException extends RuntimeException {
        public AlunoNotFoundException(String matricula) {
            super("Aluno com matrícula " + matricula + " não encontrado.");
        }
    }

    // Tratamento global de erros
    @ControllerAdvice
    public static class GlobalExceptionHandler {

        // Captura erros de validação (@Valid)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        // Captura a exceção personalizada AlunoNotFoundException
        @ExceptionHandler(AlunoNotFoundException.class)
        public ResponseEntity<String> handleAlunoNotFound(AlunoNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

        // Captura IllegalArgumentException (duplicidade, etc)
        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

        // Captura qualquer outra exceção não tratada
        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleGenericException(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro interno: " + ex.getMessage());
        }
    }
}
