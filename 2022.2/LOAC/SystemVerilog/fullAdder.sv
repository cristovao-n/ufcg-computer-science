// Cristovão Pessoa Cândido Neto - 121110199
parameter NUM_OF_BITS=8;
module fullAdder(
  input logic a, b, cin,
  output logic cout, sum
);
  
  always_comb begin
  	sum <= a ^ b ^ cin;
    cout <= (a & b) | (cin & (a ^ b));
  end
  
endmodule
