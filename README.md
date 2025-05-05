# Projeto Final - Bloco 02

Este repositório contém o desenvolvimento do projeto final da segunda etapa do curso de Java com Spring Boot. O projeto é uma simulação de um sistema de farmácia, com cadastro de **categorias** e **produtos**.

## 💻 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Insomnia (para testes de API)

---

## 🛠️ Etapas do Projeto

### ✅ Etapa 1 — Configuração do Projeto
- Criação do projeto Spring Boot: `projeto_final_bloco_02`
- Criação do repositório no GitHub
- Configuração da conexão com o banco de dados MySQL
- Testes iniciais com aplicação conectada ao banco
- Branch utilizada: `01_Configurando_Projeto`

---

### ✅ Etapa 2 — CRUD da Categoria
- Criação da classe `Categoria` com os seguintes atributos:
  - `id`, `nome`, `descricao`, `codigo`, `ativa`
- Implementação das camadas:
  - Model, Repository e Controller
- CRUD com 6 métodos:
  - Criar, listar todas, buscar por ID, atualizar, deletar por ID e deletar tudo
- Testes realizados no Insomnia
- Branch utilizada: `02_CRUD_Categoria`

---

### ✅ Etapa 3 — CRUD do Produto com Relacionamento
- Criação da classe `Produto` com os seguintes atributos:
  - `id`, `nome`, `codigoBarras`, `descricao`, `preco`, `quantidadeEstoque`, `fabricante`, `precisaReceita`, `principioAtivo`, `dosagem`, `dataValidade`
- Relacionamento `@ManyToOne` com a classe `Categoria`
- Relacionamento bidirecional configurado com `@OneToMany` em `Categoria`
- Implementação das camadas:
  - Model, Repository e Controller
- Testes realizados no Insomnia
- Branch utilizada: `03_CRUD_Produto_Relacionamento`

---

## 🔗 Requisitos Atendidos

- [x] Conexão com o banco de dados
- [x] CRUD completo para Categoria
- [x] CRUD completo para Produto com relacionamento
- [x] Testes com Insomnia
- [x] Controle de versões com Git e GitHub


## Diagrama Entidade-Relacionamento (DER)

![Diagrama DER](https://raw.githubusercontent.com/luacrds/Projeto_Final_Bloco_02/main/DER_FARMACIA.png)




### 🚧 Observação

Este projeto foi desenvolvido como parte de uma avaliação prática e está em constante evolução para fins de aprendizado.
