package cfdi.satws.messages

trait MessagesSAT {
  def getMessageDigestValueAuthentication(startDate: String, endDate: String): String
  def getMessageSignatureValueAuthentication(digestValue: String): String
}
