package com.example.demo.service;

import com.example.demo.model.Aluno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    private final List<Aluno> alunos = new ArrayList<>();

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public String adicionar(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(aluno.getMatricula())) {
                return "Erro: Matrícula " + aluno.getMatricula() + " já existe!";
            }
        }
        alunos.add(aluno);
        return "Aluno " + aluno.getNome() + " cadastrado com sucesso!";
    }

    public Aluno buscarPorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null;
    }

    public String remover(String matricula) {
        Aluno aluno = buscarPorMatricula(matricula);
        if (aluno != null) {
            alunos.remove(aluno);
            return "Aluno " + matricula + " removido com sucesso!";
        }
        return "Matrícula " + matricula + " não encontrada.";
    }
}
