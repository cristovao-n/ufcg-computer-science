/*
Problema 02 - Full Adder
Cristovão Pessoa Cândido Neto - 121110199
Fazendo usando a descrição comportamental
*/

parameter N_BITS=8;
module full_adder(
  input logic signed [N_BITS-1:0] A, input signed [N_BITS-1:0] B,
  output logic signed [N_BITS-1:0] S,
  output logic N, Z, P
);
  always_comb begin
    S <= A + B;
    N <= S < 0;
    // ou
    // N <= S[N_BITS-1] == 1;
    Z <= S == 0;
    P <= S % 2 == 0;
    // usando bitwise
    // P <= !(S & 1);
  end
  

endmodule