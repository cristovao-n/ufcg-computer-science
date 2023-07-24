// Cristovão Pessoa Cândido Neto
// 121110199
parameter NUM_BITS=7;
module circuit(
  input logic [NUM_BITS:0] A, B,
  input logic[1:0] F,
  output logic [NUM_BITS:0] OUT,
  output logic FLAG_O
  
);
  
  wire[NUM_BITS:0] sum = A+B;
  
  always_comb begin
    case (F)
      2'b00 : OUT = A & B;
      2'b01 : OUT = A | B;
      2'b10 : OUT = A + B;
      2'b11 : OUT = A - B;
    endcase
    FLAG_O <= ~(A[NUM_BITS] ^ B[NUM_BITS]) & (sum[NUM_BITS] ^ A[NUM_BITS]);
  end
  
endmodule
