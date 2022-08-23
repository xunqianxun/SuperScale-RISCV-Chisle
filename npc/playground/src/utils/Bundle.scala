package utils 

import chisel3._ 
import chisel3_util._ 

class InstFectIO extends NutCoreBundle {
    val pc        = Output(UInt(VAddrBits.w))
    val pnpc      = Output(UInt(WAddrBits.w))
    val brIdx     = Output(4.w) 
    val instValid = Ouptut(UInt(4.w))
    val icachePF  = Output(bool())
    val instr     = Output(UInt(64.w))
}


