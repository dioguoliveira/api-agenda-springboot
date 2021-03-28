# Agenda API Rest

## Sobre o projeto

A API de Agenda é um pequeno desafio que recebi para o processo de seleção de desenvolvedores de software do Instituto Creathus que é consumido pelo <a href="https://github.com/dioguoliveira/frontend-agenda-vuejs" target="_blank" >Front-end de Agenda</a>

## Execute o projeto via Docker Compose

Para executar o projeto basta apenas você ter o [Docker](https://docs.docker.com/get-docker/) e o [Docker Compose](https://docs.docker.com/compose/install/)  instalados localmente em sua máquina.

### Subir projeto sem MySQL

> **ATENÇÃO:** Esse projeto sobe um container MySQL no Docker. Caso você já tenha um servidor MySQL instalado ou um container rodando previamente, suba apenas o serviço API Agenda.

Primeiramente, você deve alterar o arquivo **docker-compose.yml**. Na seção de **api_agenda** ajuste o valor das variáveis de ambiente para aqueles referente ao seu ambiente.

Em seguida, execute o seguinte comando:

``` $ docker-compose up -d api_agenda ```


### Subir projeto com MySQL

Dentro da pasta do projeto, abra o terminal e execute o seguinte comando:

``` $ docker-compose up -d ```

Isso irá subir dois serviços:
 - Servidor MySQL
 - A aplicação da agenda (_No primeiro instante ela irá quebrar_)

A aplicação da agenda não conseguirá subir com sucesso na primeira tentativa, pois ela depende que o servidor MySQL esteja completamente iniciado. 

Em média, leva 5 minutos no máximo para o MySQL completar sua inicialização. Você pode verificar isso através do seguinte comando:

``` $ docker logs -f api-agenda-springboot_mysql_server_1```

Você deve esperar até aparecer uma mensagem como o destacado na imagem abaixo (_Clique na imagem para expandi-la_):

<a href="https://ibb.co/WBZPttg"><img src="https://i.ibb.co/JrVyQQ5/2021-03-27-21-59.png" alt="2021-03-27-21-59" border="0"></a>

Por fim, execute o comando a seguir para subir a aplicação novamente:

``` $ docker-compose up -d api_agenda```

Teste aplicação executando uma requisição GET e outras requisições descritas a seguir:

``` $ curl http://localhost:8080/api/v1/contatos```




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
Corpo JSON para requisição
```
    {
        "nome": "Nome",
        "sexo": "M",
        "telefone": "9299999999",
        "email": "email@gmail.com"
    }
```

## Swagger
Para visualizar a documentação da API acessar o <a href="http://localhost:8080/swagger-ui.html#/" target="_blank" >Swagger UI</a> que possui a documentação de todas as requisições.
