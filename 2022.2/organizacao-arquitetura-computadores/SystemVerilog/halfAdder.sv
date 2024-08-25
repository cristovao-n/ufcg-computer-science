module halfAdder(
  input logic a, b,
  output logic sum, cout
);

always_comb begin
  sum <= a ^ b;
  cout <= a & b;

end


endmodule