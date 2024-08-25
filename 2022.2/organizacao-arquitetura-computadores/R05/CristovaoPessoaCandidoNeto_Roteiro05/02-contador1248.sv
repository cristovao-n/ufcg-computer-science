// Cristovão Pessoa Cândido Neto
// 121110199

module givenSequenceCounter(
	input logic clk, reset,
  output reg [3:0] count = 1
);
  
  always_ff @(posedge clk) begin
    if (reset)
      count <= 1;
    else if (count == 8)
      count <= 1;
    else
      count <= count << 1;
  end
  
endmodule
