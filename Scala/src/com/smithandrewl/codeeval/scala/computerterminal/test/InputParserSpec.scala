package com.smithandrewl.codeeval.scala.computerterminal.test

import org.scalatest.FunSpec

class InputParserSpec extends FunSpec {
  describe("The Input Parser") {

    describe("When processing text") {
      it("Returns Text(text)") {
        fail()
      }
    }

    describe("When processing a control sequence") {
      describe("When processing ^c") {
        it("Returns Clear") {
          fail()
        }
      }

      describe("When processing ^h") {
        it("Returns Home") {
          fail()
        }
      }

      describe("When processing ^b") {
        it("Returns Begin") {
          fail()
        }
      }

      describe("When processing ^d") {
        it("Returns Move(Down)"){
          fail()
        }
      }

      describe("When processing ^u") {
        it("Returns Move(Up)") {
          fail()
        }
      }

      describe("When processing ^l") {
        it("Returns Move(Left)") {
          fail()
        }
      }

      describe("When processing ^r") {
        it("Returns Move(Right)") {
          fail()
        }
      }

      describe("When processing ^e") {
        it("Returns Erase") {
          fail()
        }
      }

      describe("When processing ^i") {
        it("Returns Mode(Insert)") {
          fail()
        }
      }

      describe("When processing ^o") {
        it("Returns Mode(Overwrite") {
          fail()
        }
      }

      describe("When processing ^^") {
        it("Returns Circumflex") {
          fail()
        }
      }

      describe("When processing ^RowCol") {
        it("Returns MoveTo(RowCol)") {
          fail()
        }
      }

    }
  }
}