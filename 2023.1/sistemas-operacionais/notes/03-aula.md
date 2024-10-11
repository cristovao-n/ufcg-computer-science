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

```cpp
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
