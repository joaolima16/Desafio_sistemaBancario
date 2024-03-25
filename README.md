
# Sistema Bancário

Sistema de cadastro de empresas e clientes com a possiblidade de realizar transações



## Funcionalidades

-  Realizar saque de valores através do saldo da empresa
-  Realizar deposito de valores através do saldo da empresa

- Gravar transações no BD em memória
- Após a transação ser concluída é enviado um e-mail com detalhes da transação.

## Documentação da API

#### Realiza o deposito de um valor

```http
  POST /client/deposit
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `CPF` | `string` | CPF do cliente |
| `CNPJ` | `string` | CNPJ da empresa
| `Valor` | `Double` | Valor do deposito |

#### Cliente realizar um saque

```http
  POST /client/withdraw
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `CPF` | `string` | CPF do cliente |
| `CNPJ` | `string` | CNPJ da empresa
| `Valor` | `Double` | Valor do saque |


## Stack utilizada

**Linguagem:** Java

**Framework:** Spring Boot

**Bibliotecas:** 
- Spring-Data-JPA
- H2 Database
- Spring-Starter-Mail
- Lombok



## Variáveis de Ambiente

Para rodar esse projeto, você vai precisar adicionar as seguintes variáveis de ambiente no seu application-test.properties

`spring.mail.username` - Seu email do outlook

`spring.mail.password` - Sua senha do email outlook


OBS: O email que está nas configurações do projeto foi criado para teste.

