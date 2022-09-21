package src 

import chisel3._ 
import chisel3.util._ 
import chisel3.experimental.BoringUtils 

class PHT extends Module {
    val io = IO(new Bundle{
        val Pht_Pc = Input(UInt(6.W))
        val Pht_Pc_Ena = Input(Bool())
        val Update_His = Input(Bool())
        val Update_Ena = Input(Bool())
        val Updata_Pc = Input(UInt(5.W))
        val Forc_Pc = Output(Bool())
    })

    val PhtSheet = Mem(64, UInt(2.W))
    val PhtOutTemp =    
}