package gui

import decorator.enums.{Colors, Geometries, LineStyles}
import decorator._
import scalafx.application.JFXApp3
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.SceneIncludes.jfxNode2sfx
import scalafx.scene.control.Label
import scalafx.scene.layout.{GridPane, VBox}

/*
  Running it from this place might throw a weird scalafx error
  in such case run from World
 */
object App extends JFXApp3 {
  final private val pane = new GridPane
  private var shape: ShapeWrapperDecorator = _

  def setShape(newShape: ShapeWrapperDecorator): Unit = {
    pane.getChildren.removeIf(node => GridPane.getColumnIndex(node) == 1)
    shape = newShape
    pane.add(shape.drawShape.shape, 1, 0)
    pane.setAlignment(Pos.Center)
  }

  def decorateGeometry(enum: Geometries.Value): Unit = {
    setShape(new GeometryDecorator(shape, enum))
  }

  def decorateLine(enum: LineStyles.Value): Unit = {
    setShape(new LineDecorator(shape, enum))
  }

  def decorateColor(enum: Colors.Value): Unit = {
    setShape(new ColorDecorator(shape, enum))
  }

  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage {
      title = "Decorator demo"
    }

    val buttons = new VBox(
      children = List(List(
        Label("Geometry")),
        Geometries.values.unsorted.map(enum => new PropButton(enum, this.decorateGeometry(_)).button),
        List(Label("\nColor")),
        Colors.values.unsorted.map(enum => new PropButton(enum, this.decorateColor(_)).button),
        List(Label("\nLine")),
        LineStyles.values.unsorted.map(enum => new PropButton(enum, this.decorateLine(_)).button),
      ).flatten: _*
    )
    pane.add(buttons, 0, 0)
    val scene = new Scene(pane, 700, 700)
    setShape(
      new ColorDecorator(
        new GeometryDecorator(
          new LineDecorator(
            new ShapeWrapperDecorator {
              override def drawShape: ShapeWrapper = new ShapeWrapper()
            }, LineStyles.SOLID
          ), Geometries.CIRCLE
        ), Colors.RED
      )
    )
    stage.setScene(scene)
    stage.show()
  }
}