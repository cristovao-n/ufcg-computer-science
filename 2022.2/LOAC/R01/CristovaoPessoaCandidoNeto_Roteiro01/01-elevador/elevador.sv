/*
Problema 01 - Elevador
Cristovão Pessoa Cândido Neto - 121110199
*/

module elevator(
    input logic A1, A2, A3, M,
    output logic P
);
  
  	// podemos escrever a expressão lógica quando já sabemos ela
  	
  always_comb P <= (A1 | A2 | A3) & ~M;
  
  
endmodule
