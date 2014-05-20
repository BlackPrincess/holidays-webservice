package controllers

import scalaz._
import scalaz.Scalaz._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import com.github.nscala_time.time.Imports._
import jp.t2v.util.locale.Implicits._

object Application extends Controller {


  def plain = Action { implicit req =>
    val kv = req.queryString
    (  for {
        year <- kv.get("year").headOption >>= { _.headOption } >>= { _.parseInt.toOption }
        month <- kv.get("month").headOption >>= { _.headOption } >>= { _.parseInt.toOption }
        day <- kv.get("day").headOption >>= { _.headOption } >>= { _.parseInt.toOption }
      } yield {
        new LocalDate(year.toInt, month.toInt, day.toInt).holidayName.getOrElse("平日")
      }
    ) match {
      case Some(s) => Ok(s)
      case None => BadRequest("Bad Request: ?year=yyyy&month=m&day=d")
    }
  }

}
