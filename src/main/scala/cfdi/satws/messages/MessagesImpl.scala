package cfdi.satws.messages

import javax.inject.{Inject, Singleton}

@Singleton
class MessagesImpl @Inject()() extends MessagesSAT {
  override def getMessageDigestValueAuthentication(startDate: String, endDate: String): String = {
    val messageDigestValue =
      "<u:Timestamp xmlns:u=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\" u:Id=\"_0\">" +
        "<u:Created>" +  startDate + "</u:Created>" +
        "<u:Expires>" + endDate + "</u:Expires>" +
        "</u:Timestamp>"
    messageDigestValue
  }

  override def getMessageSignatureValueAuthentication(digestValue: String): String = {
    val messageNodo =
      "<SignedInfo xmlns=\"http://www.w3.org/2000/09/xmldsig#\">"+
        "<CanonicalizationMethod Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"></CanonicalizationMethod>"+
        "<SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"></SignatureMethod>"+
        "<Reference URI=\"#_0\"><Transforms><Transform Algorithm=\"http://www.w3.org/2001/10/xml-exc-c14n#\"></Transform></Transforms>"+
        "<DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"></DigestMethod>"+
        "<DigestValue>" + digestValue + "</DigestValue></Reference>"+
        "</SignedInfo>"
    messageNodo
  }
}
