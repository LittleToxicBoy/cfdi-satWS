package cfdi.satws

import akka.http.scaladsl.common.StrictForm.FileData
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import cfdi.satws.complements.Complements
import cfdi.satws.descargaCDFI.CfdiRecuperacion

import java.util.UUID
import javax.inject.Inject

class CfdiMainMethods @Inject()
(
  cfdiRecuperacion: CfdiRecuperacion,
  complements: Complements
)
{
  def descargaMasiva(private_key: FileData, public_key: FileData, password: String, sd: String, ed: String, rfc: String): Route = {
    val key = UUID.randomUUID();
    val startDate: String = complements.changeDateWithTheCorrectFormat(sd)
    val endDate: String = complements.changeDateWithTheCorrectFormat(ed)
    val publicKey: Array[Byte] = complements.extractFileData(public_key)
    val privateKey: Array[Byte] = complements.extractFileData(private_key)

    val token = cfdiRecuperacion.authentificate(key, startDate, endDate, publicKey, privateKey, password)

    complete(token)
  }

}
