// Cristovão Pessoa Cândido Neto - 121110199
// Fazendo pela expressao logica do carry-out e sum bit a bit
parameter NUM_OF_BITS=8;
module bits_adder(
  input signed [NUM_OF_BITS-1:0] num1, num2,
  input logic carry_in,
  output signed [NUM_OF_BITS-1:0] sum,
  output logic carry_out
);

  wire[NUM_OF_BITS-1:0] intermediate_sum;
  wire[NUM_OF_BITS-1:0] carry;
  full_adder fa0(num1[0], num2[0], carry_in, intermediate_sum[0], carry[0]);
  full_adder fa1(num1[1], num2[1], carry[0], intermediate_sum[1], carry[1]);
  full_adder fa2(num1[2], num2[2], carry[1], intermediate_sum[2], carry[2]);
  full_adder fa3(num1[3], num2[3], carry[2], intermediate_sum[3], carry[3]);
  full_adder fa4(num1[4], num2[4], carry[3], intermediate_sum[4], carry[4]);
  full_adder fa5(num1[5], num2[5], carry[4], intermediate_sum[5], carry[5]);
  full_adder fa6(num1[6], num2[6], carry[5], intermediate_sum[6], carry[6]);
  full_adder fa7(num1[7], num2[7], carry[6], intermediate_sum[7], carry[7]);

  assign sum = intermediate_sum;
  assign carry_out = carry[7];
  
endmodule

module full_adder (
  input logic a, b, cin,
  output logic sum, cout
);
  
  always_comb begin
  	sum <= a ^ b ^ cin;
    cout <= (a & b) | (cin & (a ^ b));
  end
  
endmodule


// nesse caso é mais fácil fazer usando a descrição comportamental
// vamos simplesmente fazer A+B