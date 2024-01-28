
# fiap-food-api

API web de lanchonete para gestao de pedidos

# Configuração do Ambiente
Para configurar o ambiente de desenvolvimento para este projeto Java, siga as instruções abaixo. Certifique-se de ter o Docker instalado em seu sistema antes de prosseguir.

## Pré-requisitos
* Docker instalado em sua máquina.

## Configurando o Ambiente

1 - Clone este repositório em sua máquina local.
```
git clone https://github.com/kenzleyDev/fiap-food-api.git 
```
2 - Acesse a pasta do projeto Java no terminal (PowerShell, Git Bash ou terminal do Linux).

3 - Execute o comando Docker Compose para iniciar os serviços necessários e construir a aplicação.

```
docker-compose up --build
```

Este comando iniciará os contêineres Docker necessários para executar a aplicação, incluindo qualquer configuração adicional especificada no arquivo docker-compose.yml.

Certifique-se de aguardar até que todos os serviços sejam iniciados com êxito. Após a conclusão, a aplicação estará pronta para ser acessada localmente.

## EM CASO DE ERRO COM O BANCO DE DADOS
* Verificar no application.properties da aplicação em src/main/resources se em spring.datasource.url: está apontando para o banco de dados disponibilizado no docker

## UTILIZANDO O SWAGGER
O Swagger proporciona uma interface interativa que facilita a exploração e entendimento dos endpoints disponíveis em nossa API. Para acessar o Swagger, basta seguir os passos abaixo:

1 - Após configurar o ambiente conforme as instruções anteriores, aguarde até que a aplicação esteja completamente inicializada.

2 - Abra o seu navegador da web e acesse:

```
http://localhost:8080/swagger-ui.html

```

## Utilizando com Ferramentas de Teste de API
Se preferir utilizar ferramentas como Postman, Insomnia ou outras, siga o tutorial abaixo para realizar as chamadas aos nossos serviços:

## Consumindo API de Clientes (Customer)

### Cadastrar um Cliente:

Para cadastrar um cliente, envie uma requisição POST para:

```
localhost:8080/api/v1/customers
```
Ex:
```json
{
    "name": "Cliente teste",
    "cpf": "22222222222222222",
    "email": "cliente@mail.com",
    "password": "teste"
}
````
### Buscar um Cliente pelo CPF:
Para buscar um cliente pelo CPF, envie uma requisição GET para:

```
localhost:8080/api/v1/customers?cpf={cpf}
```

## Consumindo API de Produtos(Products)

### Cadastrar um Produto
Antes de criar um produto, certifique-se de que a categoria do produto está cadastrada. Caso não esteja, utilize:
```
localhost:8080/api/v1/category

```
Para cadastrar um produto, envie uma requisição POST para:

```
localhost:8080/api/v1/products
```

Exemplo de corpo da requisição:
```json
{
    "name": "Sorvete",
    "price": 12.0,
    "nameCategory": "Sobremesas",
    "information": "leite, chocolate",
    "quantity": 2
}
```

### Editar um Produto:
Para editar um produto, envie uma requisição PUT para:

```
localhost:8080/api/v1/products/{id}
````

Inclua as informações de edição no corpo da requisição.
Ex:
```json
{
    "name": "Hamburguer Editado",
    "price": 12.0,
    "nameCategory": "Lanches",
    "information": "Carne, presunto, queijo, ovo, calabresa, alface e tomate",
    "quantity": 2
}
```

### Deletar um Produto:
Para deletar um produto, envie uma requisição DELETE para:

```
localhost:8080/api/v1/products/{id}
```

### Buscar um Produto por Categoria:
Para buscar produtos por categoria, envie uma requisição GET para:

```
localhost:8080/api/v1/products?category={nomeCategoria}
```

##Consumindo API de Categorias (Category)

### Cadastrar uma Categoria:
Para cadastrar uma categoria, envie uma requisição POST para:

```
localhost:8080/api/v1/category
```

Exemplo de corpo da requisição:
```json
{
    "name": "Bebidas"
}
```

## Consumindo API de Pedidos (Order)
### Criar um Pedido:
Para criar um pedido, envie uma requisição POST para:

```
localhost:8080/api/v1/orders
```

Inclua as informações do pedido no corpo da requisição. O CPF do cliente é opcional, porém, para utilizar é preciso está cadastrado


Exemplo de corpo da requisição:
```json
{
  "cpfCustomer": "",
  "productsName": ["Sorvete", "Hamburguer", "Coca Cola"]
}

ou

{
  "cpfCustomer": "12345678910",
  "productsName": ["Sorvete", "Hamburguer", "Coca Cola"]
}
```
### Buscar todos os Pedidos:
Para buscar todos os pedidos, envie uma requisição GET para:

```
localhost:8080/api/v1/orders
```

## Consumindo API Fake-Checkout
Ao criar um pedido, um atributo chamado "confirmationCode" é gerado como um token vinculado ao pedido.

### Buscar um Pedido através de seu ConfirmationCode:
Para buscar um pedido através do confirmationCode, envie uma requisição GET para:

```
localhost:8080/api/v1/orders/{confirmationCode}
```


### Atualizar Status de um Pedido para CONFIRMADO (CONFIRMED):
Para atualizar o status de um pedido para CONFIRMADO, envie uma requisição PUT para:

```
localhost:8080/api/v1/orders/{confirmationCode}
````
