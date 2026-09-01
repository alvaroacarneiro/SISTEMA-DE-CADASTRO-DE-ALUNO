# 📚 Sistema de Cadastro de Alunos

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](https://opensource.org/licenses/MIT)
[![GitHub repo size](https://img.shields.io/github/repo-size/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO?style=flat-square)](https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO)
[![GitHub last commit](https://img.shields.io/github/last-commit/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO?style=flat-square)](https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO/commits/main)
[![Status](https://img.shields.io/badge/status-estável-brightgreen?style=flat-square)]()
[![JDK](https://img.shields.io/badge/JDK-17%2B-blue?style=flat-square)]()

---

## 📑 Sumário

- [Sobre o projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Tecnologias utilizadas](#-tecnologias-utilizadas)
- [Estrutura do projeto](#-estrutura-do-projeto)
- [Como executar](#-como-executar)
  - [Pré‑requisitos](#pré‑requisitos)
  - [Passo a passo](#passo-a-passo)
  - [Executando em diferentes sistemas](#executando-em-diferentes-sistemas)
- [Exemplo de uso](#-exemplo-de-uso)
- [Formato do arquivo CSV](#-formato-do-arquivo-csv)
- [Roadmap](#-roadmap)
- [Contribuição](#-contribuição)
- [Autor](#-autor)
- [Licença](#-licença)

---

## 📖 Sobre o projeto

O **Sistema de Cadastro de Alunos** é uma aplicação **Java 17** que fornece uma interface interativa via terminal para gerenciar informações acadêmicas. Com operações completas de **CRUD** (Create, Read, Update, Delete) e persistência automática em **CSV**, o sistema é ideal para consolidar conhecimentos em:

- Programação Orientada a Objetos (POO)
- Manipulação de arquivos com Java I/O
- Estruturas de dados (`ArrayList`)
- Boas práticas de codificação e organização de pacotes

Este projeto serve como uma excelente base para portfólio e estudos, sendo facilmente extensível para aplicações mais complexas (banco de dados, interface gráfica, API REST, etc.).

---

## 🎯 Funcionalidades

| Operação                | Descrição                                                                 |
| :---------------------- | :------------------------------------------------------------------------ |
| ➕ **Adicionar aluno**  | Cadastra um novo aluno, validando matrícula duplicada e notas (0 a 10).   |
| 📋 **Listar todos**     | Exibe todos os alunos com nome, matrícula, média e status (Aprovado/Reprovado). |
| 🔍 **Buscar por matrícula** | Localiza e exibe os dados completos de um aluno específico.            |
| 🗑️ **Remover aluno**    | Remove permanentemente um aluno (com confirmação).                        |
| 📊 **Média geral**      | Calcula e exibe a média aritmética de todos os alunos.                    |
| 💾 **Persistência automática** | Os dados são salvos em `dados/alunos.csv` entre execuções.              |

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Finalidade |
| :--- | :--- |
| **Java 17 (LTS)** | Linguagem principal, com recursos modernos (records, pattern matching). |
| **Java I/O** (`BufferedReader`/`FileWriter`) | Leitura/escrita de arquivos CSV. |
| **Coleções** (`ArrayList`) | Armazenamento dinâmico em memória. |
| **POO** | Encapsulamento, herança e polimorfismo na modelagem das classes. |
| **Git & GitHub** | Controle de versão e hospedagem do repositório. |

---

## 📁 Estrutura do projeto
sistema-cadastro-alunos-java/
├── src/
│ └── com/
│ └── seuprojeto/
│ ├── Main.java # Interface do usuário (menu)
│ ├── model/
│ │ └── Aluno.java # Entidade Aluno
│ └── service/
│ └── GerenciadorAlunos.java # Lógica de negócio + persistência
├── dados/
│ └── alunos.csv # Arquivo de dados (auto‑gerado)
├── .gitignore
└── README.md

text

---

## 🚀 Como executar

### Pré‑requisitos

- [Java 17+](https://adoptium.net/) (certifique‑se de que o `JAVA_HOME` está configurado corretamente)
- (Opcional) [Git](https://git-scm.com/) para clonar o repositório

### Passo a passo

```bash
# 1. Clone o repositório (ou faça o download do ZIP)
git clone https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO.git
cd SISTEMA-DE-CADASTRO-DE-ALUNO

# 2. Compile todos os arquivos
javac -d out src/com/seuprojeto/*.java src/com/seuprojeto/model/*.java src/com/seuprojeto/service/*.java

# 3. Execute a aplicação
java -cp out com.seuprojeto.Main
Executando em diferentes sistemas
Sistema	Comando de compilação	Comando de execução
Windows (CMD)	javac -d out src\com\seuprojeto\*.java src\com\seuprojeto\model\*.java src\com\seuprojeto\service\*.java	java -cp out com.seuprojeto.Main
Linux/Mac	javac -d out src/com/seuprojeto/*.java src/com/seuprojeto/model/*.java src/com/seuprojeto/service/*.java	java -cp out com.seuprojeto.Main
Dica: Se preferir, importe o projeto em uma IDE (IntelliJ, Eclipse, VS Code) e execute a classe Main diretamente.

🧪 Exemplo de uso
Ao executar o programa, o menu principal é exibido:

text
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
Ao listar os alunos (opção 2):

text
--- LISTA DE ALUNOS ---
📌 Matrícula: 2024001 | Nome: João Silva | Média: 8,17 | Status: ✅ APROVADO
📌 Matrícula: 2024002 | Nome: Maria Oliveira | Média: 9,00 | Status: ✅ APROVADO
📌 Matrícula: 2024003 | Nome: Carlos Souza | Média: 6,17 | Status: ❌ REPROVADO
Total de alunos: 3
📄 Formato do arquivo CSV
O arquivo dados/alunos.csv é gerado automaticamente com a seguinte estrutura:

csv
matricula,nome,nota1,nota2,nota3
2024001,João Silva,8.5,7.0,9.0
2024002,Maria Oliveira,9.0,8.5,9.5
2024003,Carlos Souza,6.0,5.5,7.0
O CSV pode ser aberto e editado em qualquer planilha (Excel, Google Sheets, LibreOffice Calc) para importação/exportação de dados.

🗺️ Roadmap
Etapa	Descrição	Status
1.0	Funcionalidades básicas (CRUD + persistência)	✅ Concluído
1.1	Validações de entrada e tratamento de exceções	✅ Concluído
2.0	Migração para banco de dados (SQLite)	🔄 Em planejamento
2.1	Interface gráfica com JavaFX	🔄 Em planejamento
2.2	API REST com Spring Boot	🔄 Em planejamento
3.0	Testes automatizados (JUnit)	🔄 Em planejamento
🤝 Contribuição
Contribuições são sempre bem‑vindas! Siga as diretrizes:

Fork o projeto.

Crie uma branch para sua feature:
git checkout -b feature/nova-funcionalidade

Commit suas alterações:
git commit -m 'Adiciona nova funcionalidade'

Push para a branch:
git push origin feature/nova-funcionalidade

Abra um Pull Request descrevendo suas mudanças.

Boas práticas:

Mantenha o código limpo e bem comentado.

Adicione testes para novas funcionalidades (quando aplicável).

Atualize o README se necessário.

👨‍💻 Autor
Álvaro Carneiro
https://img.shields.io/badge/LinkedIn-0077B5?style=flat&logo=linkedin&logoColor=white
https://img.shields.io/badge/GitHub-100000?style=flat&logo=github&logoColor=white
https://img.shields.io/badge/Email-D14836?style=flat&logo=gmail&logoColor=white

📄 Licença
Este projeto é distribuído sob a MIT License. Veja o arquivo LICENSE para mais detalhes.

<p align="center"> Feito com ☕ e Java. <br> <sub>Última atualização: setembro de 2026</sub> </p> ```
