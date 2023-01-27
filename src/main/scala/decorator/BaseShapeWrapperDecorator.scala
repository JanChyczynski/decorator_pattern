package decorator


abstract class BaseShapeWrapperDecorator(var shapeWrapper: ShapeWrapperDecorator)
  extends ShapeWrapperDecorator {
  override def drawShape: ShapeWrapper = shapeWrapper.drawShape
}