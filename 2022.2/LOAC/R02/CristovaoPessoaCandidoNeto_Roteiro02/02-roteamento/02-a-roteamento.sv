/*
Problema 02 a - Roteamento
Cristovão Pessoa Cândido Neto - 121110199
*/
parameter NUM_OF_BITS=4;
module mux(
  input logic[NUM_OF_BITS-1:0] A, B,
  input logic SEL,
  output logic[NUM_OF_BITS-1:0] OUT,
);
  always_comb begin 
    case(SEL)
      1'b0 : OUT <= A;
      1'b1 : OUT <= B;
      default : OUT <= 4'b0000;
    endcase
  end
endmodule
