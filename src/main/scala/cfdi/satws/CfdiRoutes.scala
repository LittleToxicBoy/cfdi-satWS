package cfdi.satws

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route

import scala.concurrent.Future
import com.main.UserRegistry._
import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.AskPattern._
import akka.util.Timeout

class CfdiRoutes {

  val cfdiRoutes: Route =
    pathPrefix("cfdi"){
      concat(
        pathPrefix("retrievable"){
          complete("OK")
        }
      )
    }

}
