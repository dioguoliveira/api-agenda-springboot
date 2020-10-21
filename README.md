# Agenda API Rest

## Sobre o projeto

A API de Agenda é um pequeno desafio que recebi para o processo de seleção de desenvolvedores de software do Instituto Creathus que é consumido pelo <a href="https://github.com/dioguoliveira/frontend-agenda-vuejs" target="_blank" >Front-end de Agenda</a>

## Intruções para configuração

Requisitos

- <a href="https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html"  target="_blank">Java 8</a>
- <a href="https://maven.apache.org/" target="_blank">Maven</a>
- <a href="https://dev.mysql.com/downloads/mysql/" target="_blank">MySQL</a>

Importe e excute o projeto em uma IDE Java, Eclipse de preferencia.

Caso queira modificar os dados do MySQL acessar o path `/api-agenda-springboot/src/main/resources`

### Rotas

```
    GET: http://localhost:8080/api/v1/contatos
    GET: http://localhost:8080/api/v1/contatos/{id}
    POST: http://localhost:8080/api/v1/contatos
    PUT: http://localhost:8080/api/v1/contatos/{id}
    DELETE: http://localhost:8080/api/v1/contatos/{id}
```

## Swagger
Para visualizar a documentação da API acessar o <a href="http://localhost:8080/swagger-ui.html#/" target="_blank" >Swagger UI</a> que possui a documentação de todas as requisições.
