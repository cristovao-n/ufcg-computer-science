module flipFlop(
	input logic clk, data_in, reset,
  	output logic data_out,
);
  // assynchronous reset
  always_ff @(posedge clk or posedge reset) begin
    if (reset)
      data_out <= 0;
    else
    	data_out <= data_in;
  end
  
  
endmodule
