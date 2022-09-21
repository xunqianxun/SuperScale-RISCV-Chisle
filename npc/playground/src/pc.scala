import chisel3._

class pc extends Module{
    val io = IO(new Bundle {
        val fect_addr       = Input(UInt(64.W))
        val pc_stall        = Input(Bool())
        val idrb1_addr      = Input(UInt(64.W))
        val idrb1_ena       = Input(Bool())
        val idrb2_addr      = Input(UInt(64.W))
        val idrb2_ena       = Input(Bool())
        val pc              = Output(UInt(64.W))
    })

    val Pc_reg = RegInit("x80000000".U(64.W))

    when(io.idrb1_ena)       {Pc_reg := io.idrb1_addr}
    .elsewhen(io.idrb2_ena)  {Pc_reg := io.idrb2_addr}
    .elsewhen(io.pc_stall)   {Pc_reg := Pc_reg    }  
    .otherwise               {Pc_reg := io.fect_addr }
    
    io.pc := Pc_reg
    
}