/*
Problema 02 b - Roteamento
Cristovão Pessoa Cândido Neto - 121110199
*/
parameter NUM_OF_BITS=4;
module mux(
  input logic[NUM_OF_BITS-1:0] A, B, C, D,
  input logic[1:0] SEL,
  output logic[NUM_OF_BITS-1:0] OUT
);
  always_comb begin 
    case(SEL)
      2'b00 : OUT <= A;
      2'b01 : OUT <= B;
      2'b10 : OUT <= C;
      2'b11 : OUT <= D;
      default : OUT <= 4'b0000;
    endcase
  end
endmodule
