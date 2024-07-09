# Redes de Computadores

Created: July 24, 2023 11:23 AM
Professor(a): Marcela
Sala: CAA 305
Período: 2023.1
Qt de faltas: 0
Qt máx de faltas: 7
Consumo de faltas: 0

4 Provas, 1 Reposição e a Final

> Livro:

### Dúvidas

-   O que significa 3g, 4g, 5g?
-   Como funciona a transmissão de pacotes em links de comunicação sem fio?
    -   Ondas eletromagnéticas?
-   O que é rede ethernet?
-   Como funciona o torrent?
    -   Arquitetura ponto a ponto
-   Quais são as vantages de se utilizar IP dinâmico?

# Introdução

## Por que estudar Redes?

-   Qual a utilidade de um computador sem conexão à internet ou a outros computadores?
-   Não é necessário entender o funcionamento por completo de redes para desenvolver software, mas é um conhecimento diferencial que um cientista da computação deve ter para resolver problemas

## Contexto histórico

Computadores começaram a ser muito utilizados na 2 guerra para cálculo de lançamento de mísseis

Os cálculos eram feitos, mas como distribuir essa informação para o cliente final? (Os soldados da guerra, por exemplo)

Seria legal se tivéssemos uma comunicação entre computadores

### Pós 2 guerra

Criação da arpanet

Redes de computadores começaram a ser criadas, porém com protocolos específicos para cada rede

Necessidade de uma generalização para permitir uma comunicação genérica

Processo de evolução longo para alcançar esse objetivo

Protocolos de email atuais: SMTP, POP e MAP ainda baseados em desenvolvimentos na década de 60

A evolução precisa abranger todo o sistema para evitar gargalos

## Comunicação genérica entre computadores

Necessidade de protocolos e infraestrutura que permitam uma comunicação padronizada entre qualquer tipo de computador

### Componentes essenciais

#### Roteadores, switches

Comutadores de pacotes

#### Links de comunicação

Fibra, cobre, rádio, satélite

#### Protocolos

Controlar o envio e recebimento de mensagens  
Padronizações

HTTP, FTP, streaming de vídeo, Skype, TCP, IP, WiFi, 4G, Ethernet, SSH, DNS

#### Padrões da internet

**IETF**: Internet Engineering Task Force

Criadora dos protocolos e padrões utilizados na internet

**IEEE**:

Especificação mais baixo nível

## Protocolo

A linguagem nada mais é que um protocolo para estabelecer a comunicação entre duas entidades  
Duas entidades que conheçam a especificação desse protocolo conseguirão se comunicar

### Fluxo de comunicação na web

DNS vai transformar o endereço textual em uma representação numérica  
IP identifica unicamente um computador na rede

### Dúvidas

> **Por que o endereço IP da máquina é diferente do endereço IP na rede geral?**
>
> Temos o IPv4 e o IPv6
>
> IPv4
>
> Quantidade de possibilidades não é suficiente para identificar unicamente todos os usuários
>
> IPv6
>
> Permite uma maior quantidade de possibilidades
>
> IP na rede local e outro IP que o roteador usa para a internet. Dessa forma temos um endereço usado pelo o roteador e todos os elementos conectados ao roteador tem seu próprio IP

-   **Aula 2**
    Foco da aula no núcleo da rede: os encaminhadores de pacotes

## Núcleo de rede

> **Encaminhamento / Comutação**
>
> Ação local: Cada roteador vai ter uma tabela que mapeia o endereço destino do pacote com o output da porta correspondente
> **Roteamento**
>
> Ação global: determinar os caminho como um todo de origem e destino

---

### Comutação de circuito

-   Recursos ponta a ponta alocados para uma chamada específica entre origem e destino
-   Analogia: Ciclovia
-   Modelo mais utilizado em redes telefônicas
    **Técnicas de implementação da computação de circuito: FDM e TDM**
    > **FDM: Frequency Division Multiplexing**
    >
    > -   Frequências alocadas para cada usuário
    > -   Ex: Rádio FM
    >     **TDM: Time Division Multiplexing**
    >
    > Cada usuário tem uma fração de tempo para enviar sua informação, ocorrendo um rodízio

---

### Comutação de pacotes

-   Usado na internet
-   Os recursos não são reservados
    > **Enfileiramento**
    >
    > Pacotes alocados em buffer
    >
    > **Store and forward:** O pacote inteiro deve chegar ao roteador antes que possa ser transmitido no próximo link

---

## Estrutura da internet: uma "rede de redes"

Os hosts se conectam à internet por meio dos ISPs: Provedores de Serviço de Internet

-   Os ISPs devem estar conectados
    > Alternativa: ISP global para conectar todo mundo
    >
    > Surgimento de concorrentes para evitar o monopólio
    >
    > IXP: Internet Exchange Points para conectar os IPSs globais
    > \*colocar imagem

## Camadas de protocolos e modelos de referências

Redes são complexas, com muitos componentes

-   hosts, roteadores, links, aplicações protocolos, hardware, software
    Camadas: cada camada implementa um serviço
    Por que camadas?
-   Modularização
-   Capacidade de mudar a implementação, mas mantendo a API, sem impactar as outras camadas
-   Exemplo: Oo serviço portão de embarque pode ser implementado de diversas formas, mas no final das contas vai produzir o resultado de embarcar todos os viajantes a bordo

### Modelos de referência

> **Modelo OSI**
>
> ISO:
>
> 7 camadas
> **Modelo TCP/IP**
>
> TCP
>
> IP
>
> 4 camadas

-   **Aula 3**

# Aula 3

### Modelo OSI

> **7 camadas**
>
> Aplicação
>
> Apresentação
>
> Sessão
>
> Transporte
>
> Rede
>
> Enlace
>
> Física
> **Física**
>
> Responsável pela parte física, transmissão de bits, níveis de tensão elétrica
> **Enlace**
>
> Não permite ligação entre redes distintas
>
> Trata o fluxo de dados no enlace entre transmissor e receptor
>
> -   Controle de fluxo baixo nível, de uma rede para outra
> -   Detecção e correção de erros
> -   Acesso ao meio compartilhado
>     **Rede** > **Transporte**
>
> -   Camada que controla o fluxo fim a fim
>     **Sessão**
>
> estabelece uma sessão entre transmissor e receptor
>
> sessão de tempo a qual a comunicação pode ser realizada
> **Apresentação**
>
> -   Tradução dos dados
> -   Compressão de textos
> -   Criptografia
> -   Conversão de padrões
>     **Aplicação**
>
> Implementa protocolos utilizados pelas aplicações para conseguirem se comunicar na rede

### Modelo TCP/IP

Usado na prática, tem menos camadas
As camadas de apresentação e sessão nem sempre são necessárias em todas as redes

-   **Aula 4**

## Aula 4

A ideia é que o núcleo da rede seja o mais simples possível e que a complexidade seja alocada nas "bordas"
Os componentes intermediários são apenas responsáveis por encaminhar os pacotes

> **Arquiteturas:**
>
> Cliente-Servidor
>
> Peer-to-peer (Ponto a ponto)

### Cliente-Servidor

Estrutura de request e response
Papéis estáticos:

-   Servidor sempre será servidor
-   Cliente sempre será cliente
    > **Servidor**
    >
    > Servidor sempre deve estar disponível
    >
    > Endereço IP permanente
    >
    > Frequentemente em data centers, para escalabilidade
    > **Cliente**
    >
    > Comunica-se com o servidor
    >
    > Endereço IP dinâmico

### Ponto a ponto

Os componentes são clientes e servidores
Auto-escalabilidade: Novos pares trazem mais capacidade de serviço, assim como mais demandas
Gerenciamento complexo: Vários dispositivos que hora podem ser cliente ou servidor
Exemplo clássico de protocolo P2P: **BitTorrent**
[About BitTorrent | Creator of the World's Leading P2P Protocol](https://www.bittorrent.com/company/about-us)
Redes: Comunicação entre processos em máquinas distintas

### Camada de Transporte

Pontos a serem considerados:

-   Transferência confiável de dados
-   Temporização
-   Algumas aplicações requerem baixa latência
-   Throughput
-   Vazão mínima necessária para o bom funcionamento da aplicação
-   Segurança - Criptografia, integridade dos dados
    Principais protocolos: TCP e UDP
    > **TCP**
    >
    > transporte confiável
    >
    > controle de fluxo
    >
    > controle de congestionamento
    >
    > orientado à conexão
    >
    > não fornece garantia mínima de taxa de transferência e segurança
    > **UDP**
    >
    > .
    >
    > .

### Protegendo o TCP

> Transport Layer Security (TLS)
>
> Implementado na camada de aplicação
>
> Criptografia

### O que um protocolo da camada de aplicação define:

> Sintaxe da mensagem
>
> Semântica da mensagem
>
> Protocolos abertos
>
> -   Definido em RFCs
> -   HTTP, SMTP
>
> Protocolos proprietários: Skype, Zoom

-   **Aula 5**

## Protocolo HTTP

-   Funciona dentro do modelo cliente-servidor

```sql
Get /index.html HTTP/1.1\r\n
Host: www-net.s.umass.edu\r\n
User-Agent: Mozilla/5.0 \r\n
Accept-Language: fr\r\n
Connection: keep-alive\r\n
\r\n
```

### Conexões persistentes x não persistentes

//pesquisar

O mais comum é utilizar a persistente por questões de desempenho

> **Cookies**
>
> Sites da Web e navegadores de clientes usam cookies para manter algum estado entre transações
>
> Quatro componentes:
>
> …
>
> Aplicações:
>
> -   Autorização
> -   Cartões de compra
> -   Recomendações
> -   Estado de sessão do usuário

> **Cache**
>
> Objetivo: atender o cliente sem envolver o servidor web dono da informação, quando possível
>
> O cache da web atua como cliente e servidor ao mesmo tempo
>
> -   Servidor quando cliente que fez a solicitação original
> -   Cliente para servidor de origem
>
> Benefícios do cache
>
> -   Reduzir o tempo de resposta
>
> Problema: Updates do servidor ocasionam em cache desatualizado
>
> Resolução:
>
> O proxy de cache faz uma requisição ao servidor para verificar se o objeto está atualizado ou não

### HTTP/2

Principal objetivo: melhorar o desempenho

-   Métodos, códigos de status e a maioria dos campos de cabeçalho permanecem inalterados em relação ao HTTP 1.1

Features:

-   Ordem de transmissão de objetos baseada em prioridade
-   push objetos não solicitados para o cliente.
-   Dividir objeto em quadros

-   2 Estágio

# 2 Estágio

## Camada de transporte - overview

-   Multiplexação e demultiplexação
-   Sockets
-   Protocolos de transporte: TCP e UDP

---

### UDP - User Datagram Protocol

> **UDP**
>
> Protocolo de transporte de Internet sem frescuras, básico.
>
> Segmentos UDP podem ser:
>
> -   perdidos
> -   entregues fora de ordem para o aplicativo
>
> Sem conexão
>
> -   sem handshaking entre o remetente e o receptor UDP
> -   Cada segmento UDP é tratado independentemente dos outros
>
> <aside>
> 💡 **Congestion in the network** is the primary reason for packet loss in UDP, as every communication network has a flow limit. For example, network congestion is similar to a traffic jam on the road, where exceeding the maximum number of vehicles allowed on a given road may cause traffic to slow or stop during peak hours
>
> </aside>
> **Por que existe UDP?**
>
> Sem handshaking
>
> Simples
>
> Tamanho de cabeçalho pequeno
>
> Sem controle de congestionamento
> **Aplicações do UDP**
>
> -   Aplicativos de streaming de multimídia
> -   DNS
> -   SNMP: Protocolo de gerência de redes
> -   HTTP/3
>     É possível usar UDP e implementar transferência confiável em outra camada

-   Adicionar confiabilidade necessária na camada de aplicativo
-   Adicionar controle de congestionamento na camada de aplicativo

### Estrutura de um pacote UDP

-   Header
-   Payload
    > **Header**
    >
    > -   source port
    > -   destination port
    > -   length
    > -   checksum

### Checksum

> **Remetente**
>
> Trata o conteúdo do segmento UDP como uma sequência de números inteiros de 16 bits
>
> adição dos bits de cada segmento
>
> Resultado armazenado no checksum
> **Destinatário**
>
> Soma os bits de cada segmento e vê se bate com o valor do checksum

---

### Princípios de transferência de dados confiável

Para garantir a confiabilidade de um protocolo que se utiliza de serviços não confiáveis, se faz necessário implementar funcionalidades que garantam essa confiabilidade
Ex: tratamentos de erros, reenvios de requisições
