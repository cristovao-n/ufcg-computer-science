# Sistemas Operacionais

Created: July 24, 2023 11:24 AM
Professor(a): Fubica
Sala: RE 09
Período: 2023.1
Qt de faltas: 0
Qt máx de faltas: 7
Consumo de faltas: 0

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

# Conceitos

## Níveis de privilégio

Necessidades do SO precisam ser implementadas pelo hardware. Exemplo: Níveis de privilégio

Níveis de privilégio limitam a execução de syscalls, limitando o que o software em execução por cima do SO pode fazer no hardware do computador

Não dá para impedir a execução de uma determinada instrução que o código fonte não deve ter acesso

Para resolver esse problema temos as exceções

> Obs: O SO é um software diferente:
>
> -   É preguiçoso
> -   Só trabalha quando eventos acontecem, diferente de um modelo de código procedural
> -   O SO possui ajudantes para realizar as operações. Ex: Para ler o disco, o SO vai programar a controladora para que ela faça a leitura
> -   As controladoras mandam interrupções para a CPU

## Vetor de interrupções:

-   Está presente na memória RAM
-   Contém instrucões sobre o que fazer para interrupções e excessões
-   SO escreve em algum registrador da cpu o endereço de memória onde está localizado o vetor de interrupções
-   TRAP: Os programas lançam uma excessão para conseguir devolver o controle ao SO para solicitar a execução de instruções que necessitam de mais privilégio

## StackPointer

É um registrador da CPU que aponta para o topo de uma pilha

Essa pilha guarda o histórico de encadeamento de chamadas das funções

Quando acontece uma interrupção ou excessão, stackpointer também precisa mudar, pois o código que passará a ser executado tem sua própria pilha

Temos uma pilha para cada programa em execução

Temos a pilha do SO para registrar os valores iniciais dos registradores antes da execução da instrução para que o estado inicial possa ser recuperado caso ocorra uma excessão

## Processo e troca de contexto

No SO teremos uma estrutura de dados chamada tabela de processos

Cada programa terá seu processo na tabela de processos

O processo é uma estrutura de dados que guarda informação sobre o programa em execução

O processo vai ter informações sobre o estado da CPU para quando a execução voltar o estado seja recuperado

OBS: O SO não executa por conta própria, apenas no boot

---

# Aula 3

## PSW

Registrador que armazenas flags da CPU das instruções anteriores, nível de privilégio

## CPU:

-   psw: Armazena nível de privilégio
-   pc: Aponta para a BIOS
-   r1

## RAM: (Parte do SO sempre estará carregada na memória)

-   bloco 0 d1
-   linuxpto
-   /bin/itnt
-   login

## BIOS:

C1

C2

---

## Programa x Processo

### Programa

Conjunto de instruções

### Processo

Instância do programa em execução  
Quando o programa é carregado na memória e cria-se uma estrutura de dados para armazenar informações sobre o programa em execução

No SO carregado na memória temos uma tabela de processos, que guarda informações sobre os programas em execução

Exemplos de informações armazenadas:

-   Estado dos valores dos registradores da CPU
-

Podemos ter vários processos executando o mesmo programa

Noção de hierarquia entre os processos:

init → login → bash → ls

## Criação de processos

Para que o processo seja criado, o SO precisa carregar o programa na memória e alocar dados na tabela de processo

No Unix, a criação do processo é feita por meio de um syscall chamado `fork` (bifurcação)

fork lança uma excessão por chamar o syscall `trap` passando o id da instrução presente na tabela de excessões que deve ser executado pelo SO

Cópia do processo pai

-   Cabeça do processo
-   Cauda do processo

fork do pai retorna o id do filho

o clone do pai é criado, incluindo a chamada do fork

a diferença é que o fork do filho retorna 0

### Exemplo: shell

Shell funciona como um REPL

pseudocódigo do shell

```c
int main() {
	while(1) {
		print("$ ");
		gets(command);
		if ((id = fork()) == 0) {
			exec(command);
		} else {
			wait(fid);
		}
	}
}
```

## Comandos

Printa informações sobre o processo atual
`ps -a`

Printa árvore de processos
`pstree`

# Aula 4

> Dúvida Interrupções x Excessões

## Escalonador

Digamos que P1 precisa acessar o disco.

P1 fará um trap para aumentar o nível de privilégio e entregar a CPU ao SO, que aí então irá se comunicar com a controladora do disco para recuperar os dados

Essa operação de leitura, falando nas ordens de grandeza de um computador, é extremamente lenta

CPU será interrompida quando a leitura for encerrada

Precisamos executar outro processo para que a CPU não fique ociosa

Quem fará esse gerenciamento é o escalonador

Escalonador decide por alguma razão que P2 irá executar

O estado da CPU de P1 precisa ser salvo para ser setado quando o processo P1 voltar a ser executado

E o estado de P2 precisa ser recuperado, caso ele já tenha sido executado anteriormente, mas não foi concluído

Precisamos de uma estrutura de dados auxiliar para o escalonador, que será uma fila

Fila com os índices dos processos na tabela de processos

Os processos dessa fila estão no status **Pronto para Rodar**

Quando a fatia de tempo do processo acabar ou ocorrer alguma outra interrupção ou excessão, o processo vai pro fim da fila e o escalonador pega o próximo

Como o escalonador decide qual é o próximo processo a ser executado?

Estratégias de definições de prioridade: round robin

Algoritmos e estruturas para determinar a prioridade de cada processo

Prioridade calculada com base na fatia de tempo utilizada, etc

### Real time Operating System

Exemplos de uso

-   Sistemas críticos: aviação
-   ***

# Aula 5

Por que ter vários processos?

Como compartilhar memória entre processos? Threads

---

# Aula 6

Espera ocupada é implementada no problema do word count

Novo problema: Produtor/Consumidor

> **Produtor/Consumidor**
>
> Nesse problema, temos outros requisitos de sincronização além dos padrões
>
> Padrão: Produtor espera pelo Consumidor caso ele esteja acessando a região crítica e vice-versa
>
> Novos requisitos:
>
> Caso o buffer esteja cheio, o produtor precisa esperar
>
> Caso o buffer esteja vazio, o consumidor precisa esperar
>
> Pseudocódigo do produtor:
>
> ```cpp
> Produtor() {
> 	while(true) {
> 		item = produz_item();
> 		if (n_itens == n) sleep();
> 		coloca_item*(item);
> 		n_itens++;
> 	}
> }
> ```
>
> ```cpp
> Consumidor() {
> 	while(true) {
> 		if (n_itens == 0) sleep();
> 		item = retira_item*();
> 		n_itens--;
> 	}
> }
> ```
>
> -   Dentro de `retira_item` e `coloca_item` temos o código que implementa a espera ocupada
>
> Problema: interrupção entre a verificação do Produtor `if (n_itens == n)` e a instrução de sleep `sleep()`
>
> Caso o Produtor produza os n itens no seu espaço de tempo da CPU, ele irá entrar em sleep e quando o Consumidor retornar ele irá entrar em sleep também
>
> Nome do problema: **deadlock**
>
> Dijkstra propôs o semáforo para resolver esse problema

### Semáforo

pseudocódigo do semáforo

```cpp
Semaforo {
	int v;
	List<ProcessoId> l;
}

void down(ProcessId process) {
	if (this.v == 0) {
		this.l.insere(process);
		wait();
	} else {
		this.v--;
	}
}

void up() {
	if (!this.l.isEmpty()) {
		wakeup(this.l.get
	} else {
		this.v++;
	}
}
```
