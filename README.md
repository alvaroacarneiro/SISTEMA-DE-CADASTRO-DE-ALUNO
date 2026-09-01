# 📚 API de Cadastro de Alunos

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk&logoColor=white)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Render](https://img.shields.io/badge/Render-Deploy-success?style=for-the-badge&logo=render&logoColor=white)](https://render.com)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)

---

## 📖 Sobre o projeto

API REST para gerenciamento de alunos, desenvolvida em **Spring Boot** com **Java 17**. Todas as funcionalidades estão centralizadas em um único arquivo (`DemoApplication.java`) para facilitar o entendimento e deploy.

---

## 🌐 Acesse a API

- **Base URL:** [https://sistema-alunos-api.onrender.com](https://sistema-alunos-api.onrender.com)
- **Documentação Swagger:** [https://sistema-alunos-api.onrender.com/swagger-ui/index.html](https://sistema-alunos-api.onrender.com/swagger-ui/index.html)

---

## 🎯 Funcionalidades

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| GET | `/alunos` | Lista todos os alunos |
| GET | `/alunos/{matricula}` | Busca aluno por matrícula |
| POST | `/alunos` | Cadastra novo aluno (JSON) |
| PUT | `/alunos/{matricula}` | Atualiza aluno existente |
| DELETE | `/alunos/{matricula}` | Remove aluno |

---

## 📁 Estrutura do projeto
SISTEMA-DE-CADASTRO-DE-ALUNO/
├── src/
│ └── main/
│ ├── java/com/example/demo/
│ │ └── DemoApplication.java # Única classe Java
│ └── resources/
│ └── application.properties
├── .gitignore
├── Dockerfile
├── pom.xml
├── render.yaml
└── README.md

text

---

## 🚀 Como executar

```bash
# Clone o repositório
git clone https://github.com/alvaroacarneiro/SISTEMA-DE-CADASTRO-DE-ALUNO.git
cd SISTEMA-DE-CADASTRO-DE-ALUNO

# Execute com Maven
mvn spring-boot:run
A API estará disponível em http://localhost:8080.

📄 Exemplo de requisição (POST)
json
{
  "matricula": "2024005",
  "nome": "Fernanda Lima",
  "nota1": 8.0,
  "nota2": 7.5,
  "nota3": 9.0
}

👨‍💻 Autor
Álvaro Carneiro


📄 Licença
Este projeto é distribuído sob a MIT License. Veja o arquivo LICENSE para mais detalhes.

 Feito com ☕ e Java. Última atualização: setembro de 2026
