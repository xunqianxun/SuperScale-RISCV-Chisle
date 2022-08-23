package src 

import chisel3._ 
import chisel3.util_ 
import chisel3.util.experimental.BoringUtils 

import util._ 

trait HasResetVector {
    val resetVector = Setting.grtLong("ResrtVecyor")
}

class ICacheUserBundle extends NutCoreBundle{
    val pc = UInt(VAddrBits.W)
    val brIdx = UInt(4.W)
    val pnpc = UInt(VAddrBits.W)
    val instValid = UInt(4.W)
}

class IFU_ooo extends NutCoreModule with HasResetVector {
    val io = IO(new Bundle {
        val imem = new SimleBusUC(userBits = ICacheUserBundleWidth, addrBits = VaddrBits)
        val out = Decoupled(new InstFectIO)
        val redirect = Flipped (new RedirectIO) 
        val bpFulsh = Output(Bool())
        val ipf = Input(bool())
    })

    val pc = RegInit(resetVector.U(Vaddrbits.W))

    val pcInstValid = RegInit("b1111".U)
    
}
