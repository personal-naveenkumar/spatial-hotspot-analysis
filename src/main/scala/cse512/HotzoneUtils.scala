package cse512

object HotzoneUtils {

  def ST_Contains(queryRectangle: String, pointString: String): Boolean = {
    val rectangleCoordinates = queryRectangle.split(",")
    val rectangleCoordinate_x1 = rectangleCoordinates(0).trim.toDouble
    val rectangleCoordinate_y1 = rectangleCoordinates(1).trim.toDouble
    val rectangleCoordinate_x2 = rectangleCoordinates(2).trim.toDouble
    val rectangleCoordinate_y2 = rectangleCoordinates(3).trim.toDouble

    val pointCoordinates = pointString.split(",")
    val pointCoordinates_x1 = pointCoordinates(0).trim.toDouble
    val pointCoordinates_y1 = pointCoordinates(1).trim.toDouble

    var maximumRectangleCoordinate_x = rectangleCoordinate_x1
    var minimumRectangleCoordinate_x = rectangleCoordinate_x2

    if(rectangleCoordinate_x1<rectangleCoordinate_x2) {
      maximumRectangleCoordinate_x = rectangleCoordinate_x2
      minimumRectangleCoordinate_x = rectangleCoordinate_x1
    }

    var maximumRectangleCoordinate_y = rectangleCoordinate_y1
    var minimumRectangleCoordinate_y = rectangleCoordinate_y2

    if(rectangleCoordinate_y1<rectangleCoordinate_y2) {
      maximumRectangleCoordinate_y = rectangleCoordinate_y2
      minimumRectangleCoordinate_y = rectangleCoordinate_y1
    }

    if(pointCoordinates_x1 >= minimumRectangleCoordinate_x && pointCoordinates_x1 <= maximumRectangleCoordinate_x && pointCoordinates_y1 >= minimumRectangleCoordinate_y && pointCoordinates_y1 <= maximumRectangleCoordinate_y)
      return true
    else
      return false
  }

}
