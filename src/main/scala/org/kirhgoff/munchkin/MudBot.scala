package org.kirhgoff.munchkin

import java.io.{BufferedReader, InputStreamReader, PrintWriter}
import java.net.Socket
import java.util.concurrent.Executors._
import java.util.concurrent.ThreadPoolExecutor

class MudBot(hostname: String, port: Int) {
  val executor:ThreadPoolExecutor =
    newFixedThreadPool(2).asInstanceOf[ThreadPoolExecutor]

  val socket = new Socket(hostname, port)
  val output = new PrintWriter (socket.getOutputStream)
  val input = new BufferedReader(new InputStreamReader(socket.getInputStream))

  def stop() = {
    try { input.close() } catch { case e:Exception => e.printStackTrace()}
    try { output.close() } catch { case e:Exception => e.printStackTrace()}
    try { socket.close() } catch { case e:Exception => e.printStackTrace()}
  }

  def startLoop() = {
    executor.execute(new MudLorePrinter(input))
    executor.execute(new UserCommandsReader(output))

    while (executor.getActiveCount == 2) {
      Thread.sleep(1000)
    }
    println("system> Exiting")
    executor.shutdownNow()
    System.exit(0)
  }

  //def enterWarzone(): Unit = ???

  //def login(login: String, passwordPath: String): Unit = ???

}
