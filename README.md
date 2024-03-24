
# Sistema Bancário

Sistema de cadastro de empresas e clientes com a possiblidade de realizar transações


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




## Funcionalidades

-  Realizar saque de valores através do saldo da empresa
-  Realizar deposito de valores através do saldo da empresa

- Gravar transações no BD
- Após a transação ser concluída é enviado um e-mail de confirmação.

