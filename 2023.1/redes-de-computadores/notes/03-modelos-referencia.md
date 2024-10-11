# Modelos de referências

Redes são complexas, com muitos componentes  
hosts, roteadores, links, aplicações protocolos, hardware, software

## Camadas

Cada camada implementa um serviço  
Por que camadas?  
Modularização  
Capacidade de mudar a implementação, mas mantendo a API, sem impactar as outras camadas  
Exemplo: Oo serviço portão de embarque pode ser implementado de diversas formas, mas no final das contas vai produzir o resultado de embarcar todos os viajantes a bordo

## Modelos de referência

### Modelo OSI

7 camadas

#### Aplicação

Implementa protocolos utilizados pelas aplicações para conseguirem se comunicar na rede

#### Apresentação

-   Tradução dos dados
-   Compressão de textos
-   Criptografia
-   Conversão de padrões

#### Sessão

Estabelece uma sessão entre transmissor e receptor  
Sessão de tempo a qual a comunicação pode ser realizada

#### Transporte

-   Camada que controla o fluxo fim a fim

#### Rede

#### Enlace

Não permite ligação entre redes distintas  
Trata o fluxo de dados no enlace entre transmissor e receptor

-   Controle de fluxo baixo nível, de uma rede para outra
-   Detecção e correção de erros
-   Acesso ao meio compartilhado

#### Física

Responsável pela parte física, transmissão de bits, níveis de tensão elétrica

### Modelo TCP/IP

4 camadas

-   Aplicação
-   Transporte
-   Rede
-   Enlace

Usado na prática, tem menos camadas  
As camadas de apresentação e sessão nem sempre são necessárias em todas as redes

## Conexões persistentes x não persistentes

Nonpersistent connections are closed after each transaction.  
Persistent connections stay open across transactions, until either the client or the server decides to close them.  
O mais comum é utilizar a persistente por questões de desempenho
