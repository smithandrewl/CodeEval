package com.smithandrewl.codeeval.scala.filesize

import java.io.File

object Main extends App {
  print(new File(args(0)).length())
}
