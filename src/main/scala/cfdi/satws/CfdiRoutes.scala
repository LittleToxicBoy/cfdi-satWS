package cfdi.satws

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route

import scala.concurrent.Future
import akka.actor.typed.ActorRef
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.AskPattern._
import akka.http.scaladsl.common.StrictForm.FileData
import akka.util.Timeout
import cfdi.satws.descargaCDFI.CfdiRecuperacion

import javax.inject.Inject

class CfdiRoutes @Inject()(cfdiRecuperacion: CfdiRecuperacion){
  val mainMethods = new CfdiMainMethods(cfdiRecuperacion)

  val cfdiRoutes: Route =
    pathPrefix("cfdi"){
      concat(
        pathPrefix("download"){
          get {
            extractRequestContext {
              _ =>
                formFields(
                  "private_key".as[FileData],
                  "public_key".as[FileData],
                  "password".as[String],
                  "startDate".as[String],
                  "endDate".as[String],
                  "rfc".as[String]
                ) {
                  (
                    private_key: FileData,
                    public_key: FileData,
                    password: String,
                    startDate: String,
                    endDate: String,
                    rfc: String
                  ) =>
                    mainMethods.descargaMasiva(private_key, public_key, password, startDate, endDate, rfc)
                }
            }
          }
        },
      )
    }

}
