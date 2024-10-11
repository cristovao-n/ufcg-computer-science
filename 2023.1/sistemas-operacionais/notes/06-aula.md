# Aula 6

Espera ocupada é implementada no problema do word count

Novo problema: Produtor/Consumidor

## Produtor/Consumidor

Nesse problema, temos outros requisitos de sincronização além dos padrões

Padrão: Produtor espera pelo Consumidor caso ele esteja acessando a região crítica e vice-versa

Novos requisitos:

Caso o buffer esteja cheio, o produtor precisa esperar

Caso o buffer esteja vazio, o consumidor precisa esperar

Pseudocódigo do produtor:

```cpp
Produtor() {
	while(true) {
		item = produz_item();
		if (n_itens == n) sleep();
		coloca_item*(item);
		n_itens++;
	}
}
```

```cpp
Consumidor() {
	while(true) {
		if (n_itens == 0) sleep();
		item = retira_item*();
		n_itens--;
	}
}
```

-   Dentro de `retira_item` e `coloca_item` temos o código que implementa a espera ocupada

Problema: interrupção entre a verificação do Produtor `if (n_itens == n)` e a instrução de sleep `sleep()`

Caso o Produtor produza os n itens no seu espaço de tempo da CPU, ele irá entrar em sleep e quando o Consumidor retornar ele irá entrar em sleep também

Nome do problema: **deadlock**

Dijkstra propôs o semáforo para resolver esse problema

### Semáforo

pseudocódigo do semáforo

```cpp
Semaforo {
	int v;
	List<ProcessoId> l;
}

void wait(ProcessId process) {
	if (this.v == 0) {
		this.l.insere(process);
		sleep();
	} else {
		this.v--;
	}
}

void sign() {
	if (!this.l.isEmpty()) {
		wakeup(this.l.get);
	} else {
		this.v++;
	}
}
```
