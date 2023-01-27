package decorator.enums

import scala.language.implicitConversions

object LineStyles extends Enumeration {
  val SOLID, DASHED, DOTTED = Value

  class LineStyles(line: Value) {
    def toDashes: List[Double] = {
      line match {
        case SOLID => List()
        case DASHED => List(21d, 37d)
        case DOTTED => List(2d, 5d)
      }
    }
  }

  implicit def toEnum(line: Value): LineStyles = new LineStyles(line)
}
