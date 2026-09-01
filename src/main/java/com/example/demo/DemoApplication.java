package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

    // Banco de dados em memória
    private final List<Aluno> alunos = new ArrayList<>();

    // Construtor: adiciona alunos de exemplo
    public DemoApplication() {
        alunos.add(new Aluno("2024001", "João Silva", 8.5, 7.0, 9.0));
        alunos.add(new Aluno("2024002", "Maria Oliveira", 9.0, 8.5, 9.5));
        alunos.add(new Aluno("2024003", "Carlos Souza", 6.0, 5.5, 7.0));
        alunos.add(new Aluno("2024004", "Ana Paula", 10.0, 9.5, 9.0));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    // --- ENDPOINTS ---

    // Página inicial HTML (bem bonita!)
    @GetMapping("/")
    public String home() {
        return "<!DOCTYPE html>\n" +
               "<html>\n" +
               "<head>\n" +
               "  <meta charset='UTF-8'>\n" +
               "  <title>API de Cadastro de Alunos</title>\n" +
               "  <style>\n" +
               "    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; text-align: center; margin-top: 60px; background: #f0f4f8; }\n" +
               "    .container { background: white; max-width: 700px; margin: 0 auto; padding: 40px; border-radius: 16px; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }\n" +
               "    h1 { color: #2c3e50; font-size: 2.2em; }\n" +
               "    .emoji { font-size: 3em; }\n" +
               "    .endpoint { background: #ecf0f1; padding: 10px; margin: 8px 0; border-radius: 8px; font-family: monospace; }\n" +
               "    .badge { display: inline-block; background: #2ecc71; color: white; padding: 4px 12px; border-radius: 20px; font-size: 0.8em; }\n" +
               "    a { color: #3498db; text-decoration: none; font-weight: bold; }\n" +
               "    a:hover { text-decoration: underline; }\n" +
               "    .footer { margin-top: 30px; font-size: 0.9em; color: #7f8c8d; }\n" +
               "  </style>\n" +
               "</head>\n" +
               "<body>\n" +
               "  <div class='container'>\n" +
               "    <div class='emoji'>📚</div>\n" +
               "    <h1>API de Cadastro de Alunos</h1>\n" +
               "    <p style='color: #555;'>Sistema de gerenciamento acadêmico <span class='badge'>ONLINE</span></p>\n" +
               "    <div style='text-align: left; margin: 25px 0;'>\n" +
               "      <div class='endpoint'>🔹 <strong>GET</strong> /alunos → Lista todos os alunos</div>\n" +
               "      <div class='endpoint'>🔹 <strong>POST</strong> /alunos → Cadastra um novo aluno (JSON)</div>\n" +
               "      <div class='endpoint'>🔹 <strong>GET</strong> /alunos/{matricula} → Busca aluno por matrícula</div>\n" +
               "      <div class='endpoint'>🔹 <strong>DELETE</strong> /alunos/{matricula} → Remove aluno</div>\n" +
               "    </div>\n" +
               "    <p style='margin-top: 20px;'><a href='/alunos'>📋 Ver lista de alunos</a></p>\n" +
               "    <p style='font-size: 0.85em; color: #95a5a6;'>Use o <strong>Postman</strong> ou <strong>cURL</strong> para testar POST e DELETE.</p>\n" +
               "    <div class='footer'>\n" +
               "      <span>🔗 Repositório: <a href='https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO' target='_blank'>GitHub</a></span>\n" +
               "    </div>\n" +
               "  </div>\n" +
               "</body>\n" +
               "</html>";
    }

    // Listar todos os alunos (com mensagem personalizada se vazio)
    @GetMapping("/alunos")
    public ResponseEntity<?> listarAlunos() {
        if (alunos.isEmpty()) {
            return ResponseEntity.ok("📭 Nenhum aluno cadastrado ainda. Use POST /alunos para adicionar.");
        }

        // Adiciona campo "media" e "status" para cada aluno
        List<AlunoResponse> response = new ArrayList<>();
        for (Aluno a : alunos) {
            response.add(new AlunoResponse(a));
        }
        return ResponseEntity.ok(response);
    }

    // Cadastrar novo aluno
    @PostMapping("/alunos")
    public ResponseEntity<String> cadastrar(@RequestBody Aluno aluno) {
        // Validação básica
        if (aluno.getMatricula() == null || aluno.getMatricula().isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Matrícula é obrigatória!");
        }
        if (aluno.getNome() == null || aluno.getNome().isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Nome é obrigatório!");
        }

        // Verifica duplicidade
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                return ResponseEntity.badRequest().body("❌ Matrícula " + aluno.getMatricula() + " já existe!");
            }
        }

        alunos.add(aluno);
        return ResponseEntity.ok("✅ Aluno " + aluno.getNome() + " (matrícula " + aluno.getMatricula() + ") cadastrado com sucesso!");
    }

    // Buscar aluno por matrícula
    @GetMapping("/alunos/{matricula}")
    public ResponseEntity<?> buscar(@PathVariable String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return ResponseEntity.ok(new AlunoResponse(a));
            }
        }
        return ResponseEntity.status(404).body("❌ Aluno com matrícula " + matricula + " não encontrado.");
    }

    // Deletar aluno por matrícula
    @DeleteMapping("/alunos/{matricula}")
    public ResponseEntity<String> deletar(@PathVariable String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                alunos.remove(a);
                return ResponseEntity.ok("🗑️ Aluno " + matricula + " removido com sucesso!");
            }
        }
        return ResponseEntity.status(404).body("❌ Aluno com matrícula " + matricula + " não encontrado.");
    }

    // --- CLASSES INTERNAS ---

    // Classe Aluno (modelo)
    static class Aluno {
        private String matricula;
        private String nome;
        private double nota1;
        private double nota2;
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

        public double getMedia() {
            return (nota1 + nota2 + nota3) / 3.0;
        }

        public String getStatus() {
            return getMedia() >= 7.0 ? "Aprovado" : "Reprovado";
        }
    }

    // Classe de resposta enriquecida (com média e status)
    static class AlunoResponse {
        private String matricula;
        private String nome;
        private double nota1;
        private double nota2;
        private double nota3;
        private double media;
        private String status;

        public AlunoResponse(Aluno a) {
            this.matricula = a.getMatricula();
            this.nome = a.getNome();
            this.nota1 = a.getNota1();
            this.nota2 = a.getNota2();
            this.nota3 = a.getNota3();
            this.media = a.getMedia();
            this.status = a.getStatus();
        }

        // Getters (obrigatórios para o JSON)
        public String getMatricula() { return matricula; }
        public String getNome() { return nome; }
        public double getNota1() { return nota1; }
        public double getNota2() { return nota2; }
        public double getNota3() { return nota3; }
        public double getMedia() { return media; }
        public String getStatus() { return status; }
    }
}
