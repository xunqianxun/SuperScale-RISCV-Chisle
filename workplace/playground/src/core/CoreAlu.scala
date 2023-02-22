package core

import chisel3._
import chisel3.util._
import utils._

/**
  * Author: GuoqiLi
  * Data  : 2023.02.18
  * Name  : CoreAlu module
*/



class CoreAlu extends Module {
  val io = IO(new CoreAluExtendsIo) 

  val RstData = "xffffffffffffffff".U

  val Add = io.Rs1Data + io.Rs2Data
  val Sub = io.Rs1Data - io.Rs2Data
  val CopValRs1 = Mux(io.Rs1Data(0), io.Rs1Data, -io.Rs1Data)
  val CopValRs2 = Mux(io.Rs2Data(0), io.Rs2Data, -io.Rs2Data)
  val cop = MuxCase(false.B, Seq(
    (CopValRs1 < CopValRs2, true.B),
    (CopValRs1 > CopValRs2, false.B)
  )) 


  val ProcessOut = LookupTreeDefault(io.OpCode, RstData, List(
    ISAOpcoode.add  ->  Add,
    ISAOpcoode.sll  ->  (io.Rs1Data << io.Rs2Data(5,0)),
    ISAOpcoode.slt  ->  Mux(io.Rs1Data < io.Rs2Data, Cat(0.U(63.W), true.B), Cat(0.U(63.W), false.B)),
    ISAOpcoode.sltu ->  Cat(0.U(63.W), cop),
    ISAOpcoode.xor  ->  (io.Rs1Data ^ io.Rs2Data),
    ISAOpcoode.srl  ->  (io.Rs1Data >> io.Rs1Data(5,0))

  ))

    io.PcOutData := io.PcInData

}

