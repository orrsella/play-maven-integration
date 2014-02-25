package controllers

import com.example.myapplication.core.Messages
import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready. Message from core: " + Messages.helloWorld))
  }
}