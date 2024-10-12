# Camada de Aplicação

-   Application protocol services
-   HTTP Protocol
-   DNS Protocol

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

## WebSockets

TODO: 

## DNS Protocol

DNS, or Domain Name System, is a fundamental component of the internet. The primary function of DNS is to resolve domain names into IP addresses. This process allows users to access websites using easy-to-remember names instead of numeric IP addresses.

### Hierarchy

-   Root Level: At the top are the root servers, which know where to find the top-level domains (TLDs), such as .com, .org, and .net.
-   TLD Level: Below the root are the TLD servers, which handle requests for specific domains under their TLD (e.g., .com).
-   Authoritative Servers: These servers store the actual IP address information for specific domains.

### How DNS Works

When you type a URL into your browser, a DNS request is initiated to resolve the domain name.  
The browser checks its cache to see if it has a recent IP address for the domain. If not, it proceeds with a DNS query.  
The request is sent to a recursive DNS resolver (often provided by your ISP). This resolver will handle the entire query process.  
If the resolver doesn't have the answer, it queries a root DNS server, which directs it to the appropriate TLD server.  
The resolver then queries the TLD server, which provides the authoritative name server for the domain.  
Finally, the resolver queries the authoritative server for the specific domain, which returns the corresponding IP address.  
The resolver sends the IP address back to the user's browser, allowing it to connect to the web server.
