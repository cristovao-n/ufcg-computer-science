// Cristovão Pessoa Cândido Neto
// 121110199
parameter NUM_BITS=7;
module comparator(
  input logic [NUM_BITS:0] A, B,
  output logic EQUALS
);
  
  wire [NUM_BITS:0] result;
  
  always_comb begin 
  	result <= !(A ^ B);
  end
  
endmodule
