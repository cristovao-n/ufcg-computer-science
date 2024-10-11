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

## Real time Operating System

Exemplos de uso

-   Sistemas críticos: aviação
-   ***
