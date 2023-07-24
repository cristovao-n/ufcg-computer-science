// Cristovão Pessoa Cândido Neto
// 121110199

module upDownCounter(
	input logic clk, reset, isAsc,
  output reg [3:0] count = 0
);
  
  always_ff @(posedge clk) begin
    if (isAsc)
      if (reset)
        count <= 0;
      else
        count <= count + 1;
    else
      if (reset)
        count <= 15;
      else
        count <= count - 1;
  end
  
endmodule
