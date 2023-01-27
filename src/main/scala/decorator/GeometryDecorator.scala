package decorator

import decorator.enums.Geometries.Geometries
import scalafx.Includes.observableList2ObservableBuffer
import scalafx.scene.paint.Color

class GeometryDecorator(
                         var _shapeWrapper: ShapeWrapperDecorator,
                         var geometry: Geometries,
) extends BaseShapeWrapperDecorator(_shapeWrapper) {
  override def drawShape: ShapeWrapper = {
    val retShape = shapeWrapper.drawShape
    val oldShape = retShape.shape
    val stroke = oldShape.getStroke
    val dash = oldShape.getStrokeDashArray

    retShape.shape = geometry.toShape
    retShape.shape.setStroke(stroke)
    retShape.shape.getStrokeDashArray.clear()
    dash.foreach(
      pixels => retShape.shape.getStrokeDashArray.add(pixels)
    )
    retShape.shape.setFill(Color.Transparent)
    retShape.shape.setStrokeWidth(3)
    retShape
  }
}