# Fluxo de comunicação na web

A ideia é que o núcleo da rede seja o mais simples possível e que a complexidade seja alocada nas "bordas"  
Os componentes intermediários são apenas responsáveis por encaminhar os pacotes

DNS vai transformar o endereço textual em uma representação numérica  
IP identifica unicamente um computador na rede

## Núcleo de rede

Encaminhadores de pacotes

### Roteamento

Ação global: determinar os caminho como um todo de origem e destino

### Encaminhamento

Ação local: Cada roteador vai ter uma tabela que mapeia o endereço destino do pacote com o output da porta correspondente

### Comutação de pacotes

-   Usado na internet
-   Os recursos não são reservados

Enfileiramento: Pacotes alocados em buffer  
Store and forward: O pacote inteiro deve chegar ao roteador antes que possa ser transmitido no próximo link

### Comutação de circuito

Recursos ponta a ponta alocados para uma chamada específica entre origem e destino  
Analogia: Ciclovia  
Modelo mais utilizado em redes telefônicas

#### Técnicas de implementação

##### FDM

Frequency Division Multiplexing

-   Frequências alocadas para cada usuário
-   Ex: Rádio FM

##### TDM

Time Division Multiplexing

Cada usuário tem uma fração de tempo para enviar sua informação, ocorrendo um rodízio

## Estrutura da internet: uma "rede de redes"

Os hosts se conectam à internet por meio dos ISPs: Provedores de Serviço de Internet  
Os ISPs devem estar conectados  
IXP: Internet Exchange Points para conectar os IPSs globais
