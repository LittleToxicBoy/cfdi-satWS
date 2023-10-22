package cfdi.satws.descargaCDFI

import java.util.UUID

trait CfdiRecuperacion {
  def authentificate(key: UUID, sDate: String, eDate: String, privKey: Array[Byte], pubKey: Array[Byte], password: String): String
}
