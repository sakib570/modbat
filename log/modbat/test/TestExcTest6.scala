package modbat.test

import modbat.dsl.After;
import modbat.dsl.Before;
import modbat.dsl.Init;
import modbat.dsl.Shutdown;
import modbat.mbt.MBT
import modbat.log.Log
import modbat.offline.ReplayRandom

object TestExcTest6 {
  def test3ba471c1785a0175() {
    MBT.clearLaunchedModels()
    MBT.setRNG (new ReplayRandom(0x3ba471c1785a0175L, Array(), 0))
    val m0: MBT = MBT.launch(null)

    m0.setExpectedException("java.lang.Exception")
    m0.executeTransition(m0.getTransition(0))
    // modbat/test/ExcTest6.scala:7: new Exception

    m0.setExpectedException("java.lang.AssertionError")
    m0.executeTransition(m0.getTransition(1))
    // modbat/test/ExcTest6.scala:13: assert
    MBT.setTestFailed(true)
    MBT.cleanup()

  }

  def main(args: Array[String]) {
    Log.setLevel(3)
    MBT.setMaybeProbability(0.5)
    if (args.contains("--rethrow-exceptions")) {
      MBT.setRethrowExceptions(true)
    }
    MBT.configClassLoader("build/modbat-test.jar")
    MBT.loadModelClass ("modbat.test.ExcTest6")
    MBT.invokeAnnotatedStaticMethods(classOf[Init], null)

    test3ba471c1785a0175()

    MBT.invokeAnnotatedStaticMethods(classOf[Shutdown], null)
  }
}
