
package com.cadastrodealuno.model;

import java.io.Serializable;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    private String matricula;
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;

    // Construtor vazio (necessário para alguns frameworks, mas útil aqui)
    public Aluno() {
    }

    // Construtor completo
    public Aluno(String matricula, String nome, double nota1, double nota2, double nota3) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // --- Getters e Setters (Encapsulamento) ---
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

    // --- Métodos de Negócio (Lógica) ---
    public double calcularMedia() {
        return (this.nota1 + this.nota2 + this.nota3) / 3.0;
    }

    public boolean isAprovado() {
        return calcularMedia() >= 7.0;
    }

    // Método para formatar os dados em uma linha CSV
    public String toCSV() {
        return matricula + "," + nome + "," + nota1 + "," + nota2 + "," + nota3;
    }

    // Método estático para criar um Aluno a partir de uma linha CSV
    public static Aluno fromCSV(String linha) {
        String[] dados = linha.split(",");
        if (dados.length == 5) {
            String matricula = dados[0];
            String nome = dados[1];
            double n1 = Double.parseDouble(dados[2]);
            double n2 = Double.parseDouble(dados[3]);
            double n3 = Double.parseDouble(dados[4]);
            return new Aluno(matricula, nome, n1, n2, n3);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("📌 Matrícula: %s | Nome: %s | Média: %.2f | Status: %s",
                matricula,
                nome,
                calcularMedia(),
                isAprovado() ? "✅ APROVADO" : "❌ REPROVADO");
    }
}
