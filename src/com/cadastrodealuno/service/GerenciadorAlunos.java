
package com.cadastrodealuno.service;

import com.cadastrodealuno.model.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAlunos {
    private List<Aluno> alunos;
    private final String CAMINHO_ARQUIVO = "dados/alunos.csv";

    public GerenciadorAlunos() {
        this.alunos = new ArrayList<>();
        carregarDoArquivo(); // Ao iniciar, carrega os dados salvos
    }

    // --- CRUD (Create, Read, Update, Delete) ---

    public void adicionarAluno(Aluno aluno) {
        // Verifica se já existe matrícula duplicada
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                System.out.println("❌ ERRO: Já existe um aluno com essa matrícula!");
                return;
            }
        }
        alunos.add(aluno);
        System.out.println("✅ Aluno " + aluno.getNome() + " cadastrado com sucesso!");
        salvarNoArquivo(); // Salva imediatamente no CSV
    }

    public void listarTodos() {
        if (alunos.isEmpty()) {
            System.out.println("⚠️ Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE ALUNOS ---");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("Total de alunos: " + alunos.size());
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public boolean removerPorMatricula(String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            salvarNoArquivo();
            System.out.println("🗑️ Aluno removido com sucesso!");
            return true;
        }
        System.out.println("❌ Matrícula não encontrada.");
        return false;
    }

    public void calcularMediaGeral() {
        if (alunos.isEmpty()) {
            System.out.println("⚠️ Nenhum aluno para calcular média.");
            return;
        }
        double soma = 0;
        for (Aluno a : alunos) {
            soma += a.calcularMedia();
        }
        double mediaGeral = soma / alunos.size();
        System.out.printf("📊 Média geral da turma: %.2f%n", mediaGeral);
    }

    // --- Persistência em Arquivo (CSV) ---

    private void salvarNoArquivo() {
        // Cria a pasta 'dados' se não existir
        File diretorio = new File("dados");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Aluno a : alunos) {
                writer.write(a.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("❌ Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            return; // Primeira execução, arquivo ainda não existe
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Aluno aluno = Aluno.fromCSV(linha);
                if (aluno != null) {
                    alunos.add(aluno);
                }
            }
            System.out.println("📂 Dados carregados do arquivo com sucesso! (" + alunos.size() + " alunos)");
        } catch (IOException e) {
            System.err.println("❌ Erro ao carregar arquivo: " + e.getMessage());
        }
    }
}package com.seuprojeto.service;

import com.seuprojeto.model.Aluno;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorAlunos {
    private List<Aluno> alunos;
    private final String CAMINHO_ARQUIVO = "dados/alunos.csv";

    public GerenciadorAlunos() {
        this.alunos = new ArrayList<>();
        carregarDoArquivo(); // Ao iniciar, carrega os dados salvos
    }

    // --- CRUD (Create, Read, Update, Delete) ---

    public void adicionarAluno(Aluno aluno) {
        // Verifica se já existe matrícula duplicada
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                System.out.println("❌ ERRO: Já existe um aluno com essa matrícula!");
                return;
            }
        }
        alunos.add(aluno);
        System.out.println("✅ Aluno " + aluno.getNome() + " cadastrado com sucesso!");
        salvarNoArquivo(); // Salva imediatamente no CSV
    }

    public void listarTodos() {
        if (alunos.isEmpty()) {
            System.out.println("⚠️ Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- LISTA DE ALUNOS ---");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("Total de alunos: " + alunos.size());
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public boolean removerPorMatricula(String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            salvarNoArquivo();
            System.out.println("🗑️ Aluno removido com sucesso!");
            return true;
        }
        System.out.println("❌ Matrícula não encontrada.");
        return false;
    }

    public void calcularMediaGeral() {
        if (alunos.isEmpty()) {
            System.out.println("⚠️ Nenhum aluno para calcular média.");
            return;
        }
        double soma = 0;
        for (Aluno a : alunos) {
            soma += a.calcularMedia();
        }
        double mediaGeral = soma / alunos.size();
        System.out.printf("📊 Média geral da turma: %.2f%n", mediaGeral);
    }

    // --- Persistência em Arquivo (CSV) ---

    private void salvarNoArquivo() {
        // Cria a pasta 'dados' se não existir
        File diretorio = new File("dados");
        if (!diretorio.exists()) {
            diretorio.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Aluno a : alunos) {
                writer.write(a.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("❌ Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) {
            return; // Primeira execução, arquivo ainda não existe
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Aluno aluno = Aluno.fromCSV(linha);
                if (aluno != null) {
                    alunos.add(aluno);
                }
            }
            System.out.println("📂 Dados carregados do arquivo com sucesso! (" + alunos.size() + " alunos)");
        } catch (IOException e) {
            System.err.println("❌ Erro ao carregar arquivo: " + e.getMessage());
        }
    }
}
