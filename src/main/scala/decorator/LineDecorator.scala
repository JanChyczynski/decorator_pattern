package decorator

import decorator.enums.LineStyles.LineStyles

class LineDecorator(var _shapeWrapper: ShapeWrapperDecorator, val line: LineStyles)
  extends BaseShapeWrapperDecorator(_shapeWrapper) {

  override def drawShape: ShapeWrapper = {
    val retShape = shapeWrapper.drawShape
    val shape = retShape.shape
    shape.getStrokeDashArray.clear()
    line.toDashes.foreach(
      pixels => shape.getStrokeDashArray.add(pixels)
    )
    retShape
  }
}