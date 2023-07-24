// Cristovão Pessoa Cândido Neto
// 121110199
parameter NUM_BITS=7;
module comparator(
  input logic [NUM_BITS:0] A, B,
  output logic EQUALS
);
  wire[NUM_BITS:0] result;
  xnotor x0(A[0], B[0], result[0]);
  xnotor x1(A[1], B[1], result[1]);
  xnotor x2(A[2], B[2], result[2]);
  xnotor x3(A[3], B[3], result[3]);
  xnotor x4(A[4], B[4], result[4]);
  xnotor x5(A[5], B[5], result[5]);
  xnotor x6(A[6], B[6], result[6]);
  xnotor x7(A[7], B[7], result[7]);
  
  always_comb EQUALS <= result[0] & result[1] & result[2] & result[3] & result[4] & result[5] & result[6] & result[7];
endmodule

module xnotor (
  input logic a, b,
  output logic result
);
  always_comb result <= !(a ^ b);
  
endmodule
