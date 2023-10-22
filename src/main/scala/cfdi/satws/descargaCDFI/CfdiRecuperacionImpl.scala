package cfdi.satws.descargaCDFI

import cfdi.satws.complements.Complements
import cfdi.satws.messages.MessagesSAT

import java.util.UUID
import javax.inject.{Inject, Singleton}

@Singleton
class CfdiRecuperacionImpl @Inject()
(
  messagesSAT: MessagesSAT,
  complements: Complements
) extends CfdiRecuperacion {
  override def  authentificate(key: UUID, startDate: String, endDate: String, privKey: Array[Byte], pubKey: Array[Byte], password: String): String = {
    val encodeCer: String = null
    val messageDigestValue = messagesSAT.getMessageDigestValueAuthentication(startDate, endDate)
    val digestValue = complements.getDigestValue(messageDigestValue)
    val messageSignatureValueAuthentication = messagesSAT.getMessageSignatureValueAuthentication(digestValue)
    "a"
  }
}
