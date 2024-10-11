# Camada de Aplicação

## O que um protocolo da camada de aplicação define:

-   Sintaxe da mensagem
-   Semântica da mensagem
-   Protocolos abertos

    -   Definido em RFCs
    -   HTTP, SMTP

-   Protocolos proprietários: Skype, Zoom

## Protocolo HTTP

-   Funciona dentro do modelo cliente-servidor

```
Get /index.html HTTP/1.1\r\n
Host: www-net.s.umass.edu\r\n
User-Agent: Mozilla/5.0 \r\n
Accept-Language: fr\r\n
Connection: keep-alive\r\n
\r\n
```

### Cookies

Sites da Web e navegadores de clientes usam cookies para manter algum estado entre transações

Quatro componentes:
…

#### Aplicações:

-   Autorização
-   Cartões de compra
-   Recomendações
-   Estado de sessão do usuário

### Cache

Objetivo: atender o cliente sem envolver o servidor web dono da informação, quando possível

-   O cache da web atua como cliente e servidor ao mesmo tempo

    -   Servidor quando cliente que fez a solicitação original
    -   Cliente para servidor de origem

#### Benefícios do cache

Reduzir o tempo de resposta

#### Problemática

Updates do servidor ocasionam em cache desatualizado  
Resolução: O proxy de cache faz uma requisição ao servidor para verificar se o objeto está atualizado ou não

### HTTP/2

Principal objetivo: melhorar o desempenho  
Métodos, códigos de status e a maioria dos campos de cabeçalho permanecem inalterados em relação ao HTTP 1.1

#### Features

-   Ordem de transmissão de objetos baseada em prioridade
-   push objetos não solicitados para o cliente.
-   Dividir objeto em quadros
