# Fiap-food-api

Aplicação web de lanchonete para gestão de pedidos

# Configuração do Ambiente

Para configurar o ambiente de desenvolvimento para este projeto Java, siga as instruções abaixo. Certifique-se de ter o Docker instalado em seu sistema antes de prosseguir.

# Pré-requisitos

Docker instalado em sua máquina.
# Configurando o Ambiente

Clone este repositório em sua máquina local.
git clone https://github.com/kenzleyDev/fiap-food-api.git
Acesse a pasta do projeto Java no terminal (PowerShell, Git Bash ou terminal do Linux).
cd fiap-food-api
Execute o comando Docker Compose para iniciar os serviços necessários e construir a aplicação.
docker-compose up --build
Este comando iniciará os contêineres Docker necessários para executar a aplicação, incluindo qualquer configuração adicional especificada no arquivo docker-compose.yml.

Certifique-se de aguardar até que todos os serviços sejam iniciados com êxito. Após a conclusão, a aplicação estará pronta para ser acessada localmente.

# EM CASO DE ERRO COM O BANCO DE DADOS

Verificar no application.properties da aplicação em src/main/resources se em spring.datasource.url: está apontando para o banco de dados disponibilizado no docker
# -- UTILIZANDO O SWAGGER

O Swagger proporciona uma interface interativa que facilita a exploração e entendimento dos endpoints disponíveis em nossa API. Para acessar o Swagger, basta seguir os passos abaixo:

Após configurar o ambiente conforme as instruções anteriores, aguarde até que a aplicação esteja completamente inicializada.
Abra o seu navegador da web e acesse:
http://localhost:8080/swagger-ui.html
# Utilizando com Ferramentas de Teste de API

Se preferir utilizar ferramentas como Postman, Insomnia ou outras, siga o tutorial abaixo para realizar as chamadas aos nossos serviços:

## Consumindo API de Clientes (Customer)

Cadastrar um Cliente:
Para cadastrar um cliente, envie uma requisição POST para:

http://localhost:8080/api/v1/customers
Exemplo de corpo da requisição:

JSON
{
  "name": "Cliente teste",
  "cpf": "22222222222222222",
  "email": "cliente@mail.com",
  "password": "teste"
}
Use o código com cuidado. Saiba mais
Buscar um Cliente pelo CPF:
Para buscar um cliente pelo CPF, envie uma requisição GET para:

http://localhost:8080/api/v1/customers?cpf={cpf}
Onde {cpf} é o CPF do cliente.

## Consumindo API de Produtos(Products)

Cadastrar um Produto
Antes de criar um produto, certifique-se de que a categoria do produto está cadastrada. Caso não esteja, utilize:

http://localhost:8080/api/v1/categories
Envie uma requisição POST para cadastrar a categoria.

Para cadastrar um produto, envie uma requisição POST para:

http://localhost:8080/api/v1/products
Exemplo de corpo da requisição:

JSON
{
  "name": "Sorvete",
  "price": 12.0,
  "nameCategory": "Sobremesas",
  "information": "leite, chocolate",
  "quantity": 2
}
Use o código com cuidado. Saiba mais
Editar um Produto:
Para editar um produto, envie uma requisição PUT para:

http://localhost:8080/api/v1/products/{id}
Onde {id} é o ID do produto.