// Cristovão Pessoa Cândido Neto
// 121110199

module parity (
  input logic clk, reset, singBit,
  output reg errorOccurred
);
  
  enum logic {EVEN, ODD} state;
  always_ff @(posedge clk) begin
    if (reset)
      state <= 0;
    else begin
      case (state)
        ODD:
          state <= (singBit == 1) ? ODD : EVEN;
        EVEN:
          state <= (singBit == 0) ? EVEN : ODD;
      endcase
    end
  end
  always_comb begin
    errorOccurred <= (state == EVEN);
  end
endmodule
