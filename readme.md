# Agendador de Horários API 

Este projeto é uma API REST desenvolvida para gerenciar agendamentos de serviços de forma automatizada. A aplicação permite criar, visualizar, alterar e excluir agendamentos, garantindo que não haja sobreposição de horários.
##
Ideia do Projeto
O Agendador de Horários foi criado para facilitar a gestão de clientes em estabelecimentos de serviço (como barbearias ou clínicas). A principal regra de negócio é a validação de disponibilidade: o sistema impede que um novo agendamento seja feito se o profissional já estiver ocupado em um intervalo de 1 hora.

Arquitetura Utilizada
A aplicação segue a Arquitetura em Camadas (Layered Architecture), o que permite uma separação clara de responsabilidades e facilidade na manutenção do código:

Camada de Exposição (Controller): Define os endpoints da API e processa as requisições HTTP.

Camada de Serviço (Service): Onde reside a lógica de negócio, como a verificação de conflitos de horário e cálculos de tempo.

Camada de Acesso a Dados (Repository): Utiliza Spring Data JPA para interagir com o banco de dados de forma abstrata.

Camada de Domínio (Entity): Mapeia as tabelas do banco de dados como objetos Java (POJOs).

## Tecnologias
- Java 21

- Spring Boot 3.x

- Spring Data JPA: Para persistência de dados.

- H2 Database: Banco de dados em memória para testes e desenvolvimento rápido.

- Lombok: Para redução de código boilerplate (getters/setters/construtores).

- Maven: Gerenciador de dependências.

## Endpoints Principais
##### POST /agendamentos: Cria um novo agendamento.

##### GET /agendamentos?data=YYYY-MM-DD: Lista os agendamentos de um dia específico.

##### PUT /agendamentos: Altera um agendamento existente.

#### DELETE /agendamentos: Remove um agendamento.

# Como Executar
Certifique-se de ter o Java 21 instalado.

Clone o repositório.

Execute o comando para iniciar a aplicação:

Bash
./mvnw spring-boot:run
Acesse o Console do Banco de Dados (H2) em: http://localhost:8080/h2-console.

JDBC URL: jdbc:h2:mem:agendamentos-db

User: sa