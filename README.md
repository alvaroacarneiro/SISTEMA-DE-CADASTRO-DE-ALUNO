📚 Sistema de Cadastro de Alunos
https://img.shields.io/badge/Java-17%252B-orange?logo=java
https://img.shields.io/badge/Maven-3.8%252B-blue?logo=apache-maven
https://img.shields.io/badge/License-MIT-yellow.svg
https://img.shields.io/badge/status-em%2520desenvolvimento-brightgreen

Sistema de gerenciamento acadêmico desenvolvido em Java 17 com persistência em CSV. Ideal para portfólio e estudos de Orientação a Objetos, Manipulação de Arquivos e Boas Práticas de Programação.

🎯 Objetivo
Este projeto foi criado para demonstrar conceitos fundamentais da programação Java em um contexto real:

Aplicação dos pilares da POO (Encapsulamento, Herança, Polimorfismo, Abstração)

Manipulação de arquivos (leitura/escrita com BufferedReader e FileWriter)

Uso de coleções (ArrayList) para gerenciar dados em memória

Tratamento de exceções e validação de dados

Estruturação de um sistema modular (separação em camadas)

✨ Funcionalidades
Operação	Descrição	Detalhe
➕ Adicionar aluno	Insere um novo aluno no sistema	Valida se a matrícula já existe; notas entre 0 e 10
📋 Listar todos	Exibe todos os alunos com suas notas, média e status	Média calculada automaticamente; status "Aprovado" (≥7.0) ou "Reprovado"
🔍 Buscar por matrícula	Localiza um aluno específico	Retorna os dados completos do aluno ou mensagem de não encontrado
🗑️ Remover aluno	Exclui um aluno pelo número de matrícula	Remove permanentemente do arquivo CSV
📊 Média geral da turma	Calcula a média aritmética de todos os alunos	Útil para análise de desempenho da turma
💾 Persistência automática	Os dados são salvos em dados/alunos.csv	Os alunos permanecem mesmo após o término do programa
🛠️ Tecnologias Utilizadas
Tecnologia	Finalidade
Java 17 (LTS)	Linguagem principal
Java I/O (BufferedReader/FileWriter)	Leitura e escrita de arquivos CSV
Coleções (ArrayList)	Armazenamento em memória
POO (Encapsulamento, Herança)	Modelagem de classes e responsabilidades
Maven (opcional)	Gerenciamento de dependências e build (pode ser adaptado)
📂 Estrutura do Projeto
text
sistema-cadastro-alunos-java/
├── src/
│   └── com/
│       └── seuprojeto/
│           ├── Main.java                 # Menu interativo (interface do usuário)
│           ├── model/
│           │   └── Aluno.java            # Classe que representa o aluno (POJO)
│           └── service/
│               └── GerenciadorAlunos.java # Lógica de negócio e persistência
├── dados/
│   └── alunos.csv                        # Arquivo gerado automaticamente
├── README.md                             # Este arquivo
└── .gitignore
🚀 Como Executar
Pré-requisitos
Java 17 (ou superior) instalado (Download)

Git (opcional, para clonar o repositório)

Passo a passo
Clone o repositório:

bash
git clone https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO.git
cd SISTEMA-DE-CADASTRO-DE-ALUNO
Compile os arquivos:

bash
javac -d out src/com/seuprojeto/*.java src/com/seuprojeto/model/*.java src/com/seuprojeto/service/*.java
Execute o sistema:

bash
java -cp out com.seuprojeto.Main
💡 Dica: Você também pode usar uma IDE como IntelliJ IDEA, Eclipse ou VS Code para executar diretamente a classe Main.

🧪 Exemplo de Uso (Menu Interativo)
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
📄 Formato do Arquivo CSV
Os dados são salvos em dados/alunos.csv com o seguinte formato:

csv
matricula,nome,nota1,nota2,nota3
2024001,João Silva,8.5,7.0,9.0
2024002,Maria Oliveira,9.0,8.5,9.5
Cada linha representa um aluno e pode ser facilmente editada em qualquer editor de planilhas.

🔧 Possíveis Melhorias Futuras
Sugestão	Descrição
🗄️ Banco de Dados	Substituir o CSV por SQLite ou PostgreSQL para persistência robusta
🖥️ Interface Gráfica	Criar uma interface com Java Swing ou JavaFX para melhor experiência
🧪 Testes Automatizados	Adicionar testes unitários com JUnit para garantir qualidade do código
📊 Relatórios	Gerar relatórios em PDF ou Excel com estatísticas da turma
🔐 Autenticação	Implementar login para acesso restrito ao sistema
🌐 API REST	Expor os dados como uma API web usando Spring Boot
📘 Aprendizados
Este projeto me permitiu consolidar conhecimentos em:

Programação Orientada a Objetos (classes, encapsulamento, herança)

Manipulação de arquivos em Java (leitura/escrita com I/O)

Tratamento de exceções e validação de entrada do usuário

Estruturação de código em pacotes para melhor organização

Controle de versão com Git e GitHub

🤝 Contribuição
Contribuições são sempre bem-vindas! Se você tem sugestões ou correções, siga os passos:

Faça um fork do projeto.

Crie sua branch (git checkout -b feature/nova-funcionalidade).

Faça commit das suas mudanças (git commit -m 'Adiciona nova funcionalidade').

Envie para o repositório (git push origin feature/nova-funcionalidade).

Abra um Pull Request.

📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

📬 Contato
Autor: Álvaro Carneiro

GitHub: alvaroacarneiro

LinkedIn: (https://www.linkedin.com/in/alvaroacarneiro/)

⭐ Se este projeto te ajudou, considere dar uma estrela no GitHub!
Isso me motiva a continuar criando conteúdos de qualidade para a comunidade. 😊

