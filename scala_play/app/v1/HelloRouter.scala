package v1

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

class HelloRouter @Inject()(controller: HelloController) extends SimpleRouter {
  val prefix = "/v1/hello"

  override def routes: Routes = {
    case GET(p"/") => controller.get()
  }

}
