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
