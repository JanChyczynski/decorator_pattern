import gui.App

object World {
  //it might throw an arrow about a delegate being null
  //in such case run from App
  def main(args: Array[String]): Unit = {
    App.start()
  }
}