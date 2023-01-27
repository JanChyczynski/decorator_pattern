package gui

import scalafx.scene.control.Button

class PropButton[T](prop: T, callback: T => _){
  val button: Button = new Button(prop.toString)
  button.setOnAction(_ => callback(prop))
}
