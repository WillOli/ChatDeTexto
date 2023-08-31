# ChatTexto

O projeto ChatTexto é uma aplicação Java desenvolvida com o uso do Spring Boot, que demonstra um sistema de chat simples. Ele permite que os usuários criem chats, enviem mensagens e visualizem o histórico das conversas.

## Funcionalidades

- Registro de usuários
- Criação de chats entre dois usuários
- Envio de mensagens dentro de um chat existente
- Visualização de detalhes do chat e das mensagens

## Requisitos de Instalação

Certifique-se de ter o Java e o Maven instalados em sua máquina.

1. Clone este repositório:

```
git clone https://github.com/seu-nome-de-usuário/ChatTexto.git
```

2. Navegue até o diretório do projeto:

```
cd ChatTexto
```

3. Execute a aplicação Spring Boot:

```
mvn spring-boot:run
```

## Uso

Após iniciar a aplicação, você pode interagir com ela usando ferramentas como cURL, Postman ou até mesmo um navegador web. Aqui estão alguns exemplos de endpoints que você pode acessar:

- Criar um novo usuário:

```
POST http://localhost:8080/chats
```

Corpo da requisição:
```json
{
    "name": "Nome do Usuário"
}
```

- Criar um chat entre dois usuários:

```
POST http://localhost:8080/chats/{idUser1}/{idUser2}
```

- Enviar uma mensagem dentro de um chat:

```
POST http://localhost:8080/chats/chat/{idChat}/user/{idUser}
```

Corpo da requisição:
```json
{
    "texto": "Conteúdo da Mensagem"
}
```

- Visualizar detalhes do chat:

```
GET http://localhost:8080/chats/chat/{id}
```


## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
