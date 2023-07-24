// Cristovão Pessoa Cândido Neto
// 121110199
parameter ADDR_LENGTH = 2;
parameter DATA_LENGTH = 4;
module ram_rw(
  input logic clk, SEL, reset,
  input logic [DATA_LENGTH-1:0] Din,
  input logic [ADDR_LENGTH-1:0] Addr,
  output logic [DATA_LENGTH-1:0] Dout
);
  logic [DATA_LENGTH-1:0] mem [0:(1 << ADDR_LENGTH)-1];
  
  always_ff @(posedge clk) begin
      if (SEL) begin  // write
        if (reset)
          mem[Addr] <= 4'b0000;
        else
          mem[Addr] <= Din;
      end
    else      // read
      Dout <= mem[Addr];
  end
endmodule
