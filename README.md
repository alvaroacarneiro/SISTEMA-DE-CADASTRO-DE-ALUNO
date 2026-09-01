# 📚 Sistema de Cadastro de Alunos

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![GitHub repo size](https://img.shields.io/github/repo-size/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO?style=for-the-badge)](https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO)
[![GitHub last commit](https://img.shields.io/github/last-commit/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO?style=for-the-badge)](https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO/commits/main)

---

## 📖 Sobre o projeto

O **Sistema de Cadastro de Alunos** é uma aplicação desenvolvida em **Java 17** que permite gerenciar informações acadêmicas de forma simples e eficiente. Com uma interface interativa via terminal, o sistema oferece operações completas de CRUD (Create, Read, Update, Delete) com persistência automática em arquivo **CSV**.

Este projeto foi concebido para demonstrar a aplicação prática dos fundamentos da **Programação Orientada a Objetos**, **manipulação de arquivos** e **estruturas de dados** em Java, sendo uma excelente base para estudos e portfólio.

---

## 🎯 Funcionalidades

| Operação                | Descrição                                                                 |
| :---------------------- | :------------------------------------------------------------------------ |
| ➕ **Adicionar aluno**  | Cadastra um novo aluno com validação de matrícula duplicada e notas entre 0 e 10. |
| 📋 **Listar todos**     | Exibe todos os alunos com nome, matrícula, média e status (Aprovado/Reprovado). |
| 🔍 **Buscar por matrícula** | Localiza e exibe os dados completos de um aluno específico.            |
| 🗑️ **Remover aluno**    | Remove permanentemente um aluno do sistema, com confirmação.               |
| 📊 **Média geral**      | Calcula e exibe a média aritmética de todos os alunos cadastrados.         |
| 💾 **Persistência automática** | Os dados são salvos em `dados/alunos.csv`, garantindo integridade entre execuções. |

---

## 🛠️ Tecnologias utilizadas

<div align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" alt="Java" width="60" height="60"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/git/git-original-wordmark.svg" alt="Git" width="60" height="60"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original-wordmark.svg" alt="GitHub" width="60" height="60"/>
</div>

- **Java 17 (LTS)** – Linguagem principal, com recursos modernos como records e pattern matching.
- **Java I/O** – Leitura e escrita de arquivos com `BufferedReader` e `FileWriter`.
- **Coleções** – Uso de `ArrayList` para gerenciamento dinâmico dos dados em memória.
- **POO** – Aplicação de encapsulamento, herança e polimorfismo na modelagem das classes.
- **Git** – Controle de versão e histórico de desenvolvimento.

---

## 📁 Estrutura do projeto

```bash
sistema-cadastro-alunos-java/
├── src/
│   └── com/
│       └── seuprojeto/
│           ├── Main.java                   # Interface do usuário (menu interativo)
│           ├── model/
│           │   └── Aluno.java              # Classe que representa a entidade Aluno
│           └── service/
│               └── GerenciadorAlunos.java  # Camada de negócio e persistência
├── dados/
│   └── alunos.csv                          # Arquivo de dados gerado automaticamente
├── .gitignore
└── README.md
🚀 Como executar
Pré‑requisitos
Java 17+ instalado

(Opcional) Git para clonar o repositório

Passo a passo
bash
# 1. Clone o repositório
git clone https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO.git
cd SISTEMA-DE-CADASTRO-DE-ALUNO

# 2. Compile todos os arquivos
javac -d out src/com/seuprojeto/*.java src/com/seuprojeto/model/*.java src/com/seuprojeto/service/*.java

# 3. Execute a aplicação
java -cp out com.seuprojeto.Main
Nota: Se preferir, você pode importar o projeto em uma IDE (IntelliJ, Eclipse, VS Code) e executar a classe Main diretamente.

🧪 Exemplo de uso
Ao executar o sistema, o usuário se depara com o seguinte menu interativo:

bash
========================================
  📚 SISTEMA DE CADASTRO DE ALUNOS  
========================================
1️⃣  Cadastrar novo aluno
2️⃣  Listar todos os alunos
3️⃣  Buscar aluno por matrícula
4️⃣  Remover aluno
5️⃣  Calcular média geral da turma
0️⃣  Sair
👉 Escolha uma opção: 1

--- NOVO CADASTRO ---
Matrícula: 2024001
Nome: João Silva
Nota 1: 8.5
Nota 2: 7.0
Nota 3: 9.0
✅ Aluno João Silva cadastrado com sucesso!
Ao listar os alunos:

bash
--- LISTA DE ALUNOS ---
📌 Matrícula: 2024001 | Nome: João Silva | Média: 8,17 | Status: ✅ APROVADO
📌 Matrícula: 2024002 | Nome: Maria Oliveira | Média: 9,00 | Status: ✅ APROVADO
Total de alunos: 2
