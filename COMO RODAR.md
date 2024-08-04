<h1>Como Rodar</h1> 

## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto: 

```
git clone https://github.com/casluq/rpinfotest
```

Abra o terminal na pasta do projeto e utilize o comando:

```
./mvnw clean spring-boot:run
```

## Endpoints disponíveis :
GET:    http://localhost:8080/ordensDeServico\
GET:    http://localhost:8080/ordensDeServico/pendentes\
GET:    localhost:8080/ordemDeServico/:id\
POST:   localhost:8080/ordemDeServico\
PUT:    localhost:8080/ordemDeServico/:id/iniciarManutencao\
PUT:    localhost:8080/ordemDeServico/:id/finalizarManutencao\
PUT:    localhost:8080/ordemDeServico/:id/adicionarAnotacao\
DELETE: localhost:8080/ordemDeServico/:id\

## Como rodar os testes

Ainda no terminal e na pasta do projeto basta usar o comando abaixo:

```
./mvnw test
```