// Cristovão Pessoa Cândido Neto
// 121110199
parameter ADDR_LENGTH = 2;
parameter DATA_LENGTH = 4;
module ram_rom(
  input logic [ADDR_LENGTH-1:0] Addr,
  output logic [DATA_LENGTH-1:0] Dout
);
  always_comb begin
    case (Addr)
      2'b00 : Dout = 4'b0100;
      2'b01 : Dout = 4'b1100;
      2'b10 : Dout = 4'b0110;
      2'b11 : Dout = 4'b0111;
    endcase
  end
endmodule
