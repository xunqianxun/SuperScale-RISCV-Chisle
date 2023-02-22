package core

import chisel3._
import chisel3.util._
import utils._

/**
  * Author: GuoqiLi
  * Data  : 2023.02.18
  * Name  : CoreIoD module
*/

class CoreAluExtendsIo extends Bundle {
    val PcInData       = Input(UInt(64.W))
    val TypeCode       = Input(UInt(8.W))
    val OpCode         = Input(UInt(8.W))
    val Rs1Data        = Input(UInt(64.W))
    val Rs1Addr        = Input(UInt(6.W))
    val Rs2Data        = Input(UInt(64.W))
    val Rs2Addr        = Input(UInt(6.W))
    val ProcessData    = Output(UInt(64.W))
    val ProcessAddr    = Output(UInt(6.W))
    val PcOutData      = Output(UInt(64.W))
    val CtrlStop       = Input(Bool())
}

class CoreIfuExtrndsIo extends Bundle {
    val ForcPc   = Input(UInt(64.W))
    val CtrlStop = Input(Bool()) 
    val OutPc    = Output(UInt(64.W)) 
}