// constants that can be useful in the module
parameter ONE_MINUTE_IN_SECONDS=60, NUM_OF_BITS=8;
// define the module API, the inputs, the outputs, as well as their types
module logicGates(
  input logic a,
  input logic b,
  output logic orGate,
  output logic andGate,
  output logic xorGate,
  output logic notGate,
  output logic xnorGate
);
  
  // the expression is a combinational circuit
  always_comb begin
    orGate <= a | b;
    andGate <= a & b;
    xorGate <= a ^ b;
    notGate <= !a;
    xnorGate <= !(a ^ b);
  end  
  
  
endmodule