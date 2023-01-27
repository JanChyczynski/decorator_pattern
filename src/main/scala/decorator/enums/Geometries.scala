package decorator.enums

import scalafx.scene.shape.{Circle, Polygon, Rectangle, Shape}

import scala.language.implicitConversions

object Geometries extends Enumeration {
  val TRIANGLE, SQUARE, CIRCLE = Value

  class Geometries(value: Value) {
    def toShape: Shape = {
      val defSize = 350d;
      value match {
        case TRIANGLE => Polygon(0, defSize, defSize, defSize, defSize/2, 0)
        case SQUARE => Rectangle(defSize, defSize)
        case CIRCLE => Circle(defSize/2)
      }
    }
  }

  implicit def toEnum(value: Value): Geometries = new Geometries(value)
}