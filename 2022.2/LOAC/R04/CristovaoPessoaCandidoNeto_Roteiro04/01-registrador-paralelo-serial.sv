// Cristovão Pessoa Cândido Neto
// 121110199
parameter DATA_LENGTH = 4;
module register(
  input logic clk, reset, SEL,
  input logic Din_serie,
  input logic [DATA_LENGTH-1:0] Din,
  output logic [DATA_LENGTH-1:0] Dout
);
  
  always_ff @(posedge clk) begin
    if (!SEL) begin // paralelo
      if (reset)
        Dout <= 4'b0000;
      else
        Dout <= Din;
    end else begin  // serial
      if (reset)
        Dout <= 4'b0000;
      else
        Dout <= {Din_serie, Dout[DATA_LENGTH-1:1]};
    end
  end
endmodule
