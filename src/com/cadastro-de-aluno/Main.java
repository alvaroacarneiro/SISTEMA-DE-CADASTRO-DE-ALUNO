package com.seuprojeto;

import com.seuprojeto.model.Aluno;
import com.seuprojeto.service.GerenciadorAlunos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n========================================");
            System.out.println("  📚 SISTEMA DE CADASTRO DE ALUNOS  ");
            System.out.println("========================================");
            System.out.println("1️⃣  Cadastrar novo aluno");
            System.out.println("2️⃣  Listar todos os alunos");
            System.out.println("3️⃣  Buscar aluno por matrícula");
            System.out.println("4️⃣  Remover aluno");
            System.out.println("5️⃣  Calcular média geral da turma");
            System.out.println("0️⃣  Sair");
            System.out.print("👉 Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1; // Opção inválida
            }

            switch (opcao) {
                case 1 -> cadastrarAluno(scanner, gerenciador);
                case 2 -> gerenciador.listarTodos();
                case 3 -> buscarAluno(scanner, gerenciador);
                case 4 -> removerAluno(scanner, gerenciador);
                case 5 -> gerenciador.calcularMediaGeral();
                case 0 -> System.out.println("👋 Saindo... Até logo!");
                default -> System.out.println("❌ Opção inválida! Digite um número de 0 a 5.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    // Métodos auxiliares para organizar o código

    private static void cadastrarAluno(Scanner scanner, GerenciadorAlunos gerenciador) {
        System.out.println("\n--- NOVO CADASTRO ---");
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        double n1, n2, n3;
        try {
            System.out.print("Nota 1: ");
            n1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nota 2: ");
            n2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Nota 3: ");
            n3 = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Erro: Digite apenas números válidos para as notas.");
            return;
        }

        Aluno aluno = new Aluno(matricula, nome, n1, n2, n3);
        gerenciador.adicionarAluno(aluno);
    }

    private static void buscarAluno(Scanner scanner, GerenciadorAlunos gerenciador) {
        System.out.print("\n🔍 Digite a matrícula para buscar: ");
        String matricula = scanner.nextLine();
        Aluno aluno = gerenciador.buscarPorMatricula(matricula);
        if (aluno != null) {
            System.out.println("\n✅ ALUNO ENCONTRADO:");
            System.out.println(aluno);
        } else {
            System.out.println("❌ Aluno não encontrado.");
        }
    }

    private static void removerAluno(Scanner scanner, GerenciadorAlunos gerenciador) {
        System.out.print("\n🗑️ Digite a matrícula para remover: ");
        String matricula = scanner.nextLine();
        gerenciador.removerPorMatricula(matricula);
    }
}
