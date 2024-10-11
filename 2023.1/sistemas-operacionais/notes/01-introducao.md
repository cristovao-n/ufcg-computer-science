# Sistemas Operacionais

### Dúvidas

-   Como funciona a compatibilidade em um dispositivo de I/O com um teclado que funciona tanto em ARM quanto no x86?

# Introdução

## Para que serve o SO?

-   Facilitar a nossa vida
-   Gerenciamento de recursos
-   Segurança

### Facilitar a nossa vida

O SO lida com detalhes e um nível de abstração muito baixo para lidar com o hardware do computador, o qual precisa de um grande número de instruções e processos para funcionar.

O SO provê uma camada de abstração e dispõe uma API chamada System Call para as aplicações utilizarem, sobretudo as bibliotecas das linguagens de programação.

Dessa forma, quando executamos a função `read` em **C++**, por exemplo, internamente temos uma chamada a um syscall para ler dados da entrada padrão.

### Gerenciamento de recursos

Em uma máquina de apenas um core, quando um programa binário gerado por um compilador C, por exemplo, está sendo executado, o SO perde o controle, pois suas instruções não estão sendo lidas pelo processador. Para que isso seja recuperado temos as interrupções e as excessões

[Interrupts and Exceptions - GeeksforGeeks](https://www.geeksforgeeks.org/interrupts-and-exceptions/)

Ambas enviam sinais elétricos ao processador solicitando que o SO volte ao controle

#### Interrupções

-   Gerada pelo hardware
-   Temos o hardware **Timer** que executa periodicamente para que o SO consiga retomar o controle do computador caso ocorra algum problema no código que estava sendo executado (loop infinito, por exemplo)

#### Exceções

-   Gerada pelo software
-   Erros em tempo de execução que interrompem a leitura das instruções do software

> Exemplo: Divisão por 0

## Fluxo de execução ao ligar o computador

-   Instruções read-only da BIOS são executadas (Read-only memory - ROM)
-   Uma série de verificações são feitas para diagnosticar o status do computador
-   A BIOS terá informação sobre o endereço onde está localizado o `bootloader` ou o sistema operacional para que o `Program Counter` tenha acesso às próximas instruções a serem executadas
-   O SO é inicializado

---
