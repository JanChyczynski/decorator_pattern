package decorator.enums

import scalafx.scene.paint.Color

import scala.language.implicitConversions

object Colors extends Enumeration {
  val RED, GREEN, BLUE = Value

  class Colors(color: Value) {
    def toColor: Color = {
      color match {
        case Colors.RED => Color.IndianRed
        case Colors.GREEN => Color.DarkSeaGreen
        case Colors.BLUE => Color.CornflowerBlue
      }
    }
  }

  implicit def toEnum(color: Value): Colors = new Colors(color)
}
