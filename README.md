# Worker Income Tracker 

Este projeto é uma API REST desenvolvida em **Spring Boot 3** e **Java 21**, focada no gerenciamento de contratos de prestação de serviços e cálculo de renda mensal de trabalhadores. O sistema demonstra a aplicação prática de **Composição de Objetos** e mapeamento objeto-relacional (ORM) com **JPA/Hibernate**.

## Objetivos do Projeto

* **Modelagem de Domínio**: Implementar associações 1:N (Um trabalhador para vários contratos) e N:1 (Vários trabalhadores para um departamento).
* **Regras de Negócio**: Cálculo dinâmico de renda (`income`) baseado em salário base somado ao valor total de contratos em um mês/ano específico.
* **Persistência de Dados**: Uso de Spring Data JPA para gerenciar entidades em um banco de dados relacional.
* **Exposição de Dados (DTO)**: Uso de **Java Records** como Data Transfer Objects para retornar respostas limpas e otimizadas.

## Arquitetura e Modelo de Domínio

O projeto segue a arquitetura em camadas e utiliza o seguinte modelo de classes:

* **Worker**: Entidade principal que contém o nível do trabalhador (Enum), departamento e a lista de contratos.
* **Department**: Representa o setor de atuação.
* **HourContract**: Representa um contrato individual com data, valor por hora e duração.
* **WorkerLevel**: Enumeração que define os níveis `JUNIOR`, `MID_LEVEL` e `SENIOR`.

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 4**
* **Spring Data JPA**
* **H2 Database** (Banco de dados em memória para testes)
* **Jakarta Persistence** (Anotações `@Entity`, `@OneToMany`, `@ManyToOne`)

## Funcionalidades e Endpoints

### Cálculo de Renda Mensal

A API permite consultar quanto um trabalhador específico recebeu em determinado mês e ano.

* **Endpoint**: `GET /workers/{id}/income/{year}/{month}`
* **Exemplo de Resposta (JSON)**:
```json
{
  "name": "Alex",
  "department": "Design",
  "income": 3000.0
}

```



### Diferenciais Técnicos

* **Carga Inicial de Dados**: Implementação de uma classe `SeedingConfig` que popula o banco de dados automaticamente na inicialização via `CommandLineRunner`.
* **Cascade e Transacionalidade**: Uso de `CascadeType.ALL` para persistir contratos automaticamente ao salvar um trabalhador, garantindo a integridade referencial.
* **Lógica Encapsulada**: O cálculo da renda é feito dentro da entidade `Worker`, respeitando os princípios de encapsulamento da POO.

## Como Executar

1. Clone o repositório.
2. Certifique-se de ter o JDK 21 instalado.
3. Execute o projeto via terminal:
```bash
./mvnw spring-boot:run

```


4. A aplicação estará disponível em `http://localhost:8080`.

---

**Autor:** José Victor
(Projeto de estudo)
---
