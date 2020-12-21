package v1

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class HelloController @Inject()(val controllerComponents: ControllerComponents)
                               (implicit ec: ExecutionContext) extends BaseController {
  def get(): Action[AnyContent] = Action.async { implicit request =>
    Future {
      Ok(Json.obj("Hello" -> "Home"))
    }
  }

}
