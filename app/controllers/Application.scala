package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import com.github.nscala_time.time.Imports._
import jp.t2v.util.locale.Implicits._

object Application extends Controller {


  def plain = Action { implicit req =>
    {  for {
        year <- req.queryString("year").headOption
        month <- req.queryString("month").headOption
        day <- req.queryString("day").headOption
      } yield new LocalDate(year.toInt, month.toInt, day.toInt).holidayName.getOrElse("平日")
    } match {
      case Some(s) => Ok(s)
      case None => BadRequest
    }
  }

}