# WebSystemR API

O **WebSystemR** é uma API REST desenvolvida em Java com Spring Boot, criada para organizar e gerenciar ordens de serviço de forma eficiente, facilitando o trabalho de prestadores de serviços e melhorando a experiência dos clientes.

A aplicação permite o gerenciamento de usuários, autenticação, controle de permissões, armazenamento de dados em banco relacional e futuras funcionalidades voltadas para gestão de serviços, clientes e operações administrativas.

---

# 🚀 Objetivo do Projeto

O sistema foi desenvolvido com foco em:

* Organização de ordens de serviço
* Controle de usuários e permissões
* Gerenciamento de informações de clientes
* Estrutura profissional baseada em API REST
* Escalabilidade e manutenção facilitada

---

# 💻 Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* MySQL
* Lombok
* Jakarta Validation
* Maven

---

# 🛠️ Dependências Utilizadas

* Lombok
* Spring Web
* Spring Data JPA
* Validation
* MySQL Driver

---

# 🧱 Arquitetura do Projeto

```text
src/main/java
 └── com.systemr
      ├── controller
      ├── service
      ├── repository
      ├── entity
      |-- enums
      ├── dto
      ├── config
      ├── exception
      └── security
```

---

# 🔐 Controle de Acesso

O sistema utiliza controle de perfis através de ENUM:

* ADMIN
* USER

Usuários administradores possuem permissões elevadas para gerenciamento do sistema e controle de usuários.

---

# 🗄️ Banco de Dados

Banco relacional utilizado:

* MySQL

A aplicação utiliza Spring Data JPA para persistência e gerenciamento dos dados.

---

# 📌 Funcionalidades Planejadas

* Cadastro de usuários
* Controle de autenticação
* Geração de ordens de serviço
* Controle de permissões
* Dashboard administrativo
* Relatórios
* Integração com JWT e Spring Security

---

# 🧠 IDE Recomendada

* IntelliJ IDEA
* VSCODE
---

Desenvolvido com 💡 por Ricardo Rosendo
