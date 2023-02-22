package core

import chisel3._
import chisel3.util._
import utils._

/**
  * Author: GuoqiLi
  * Data  : 2023.02.18
  * Name  : CoreIfu module
*/


class CoreIfu extends Module {
    val io = IO(new CoreIfuExtrndsIo)

    val PcData = RegInit(0x8000000.U)


    PcData    := io.ForcPc
    io.OutPc  := PcData
}