package decorator

import decorator.enums.Colors.Colors

class ColorDecorator(val _shapeWrapper: ShapeWrapperDecorator, val color: Colors)
  extends BaseShapeWrapperDecorator(_shapeWrapper) {
  override def drawShape: ShapeWrapper = {
    val retShape = shapeWrapper.drawShape
    retShape.shape.setStroke(color.toColor)
    retShape
  }
}