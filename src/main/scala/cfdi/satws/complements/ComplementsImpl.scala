package cfdi.satws.complements

import akka.http.scaladsl.common.StrictForm
import org.apache.commons.codec.digest.DigestUtils

import java.nio.charset.Charset
import java.text.SimpleDateFormat
import java.util.Base64
import javax.inject.Singleton

@Singleton
class ComplementsImpl extends Complements {
  override def changeDateWithTheCorrectFormat(date: String): String = {
    val currentFormat = new SimpleDateFormat("yyyy-MM-dd")
    val newFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'.000Z'")
    try {
      val parsedDate = currentFormat.parse(date)
      val formattedDate = newFormat.format(parsedDate)
      formattedDate.toString
    } catch {
      case e: java.time.format.DateTimeParseException =>
        "Formato de fecha incorrecto: " + date
    }
  }

  override def extractFileData(fileData: StrictForm.FileData): Array[Byte] = {
    val bytes: Array[Byte] = fileData.entity.data.toArray
    bytes
  }

  override def getDigestValue(messageDigestValue: String): String = {
    val digestValue = Base64.getEncoder.encodeToString(DigestUtils.sha1(messageDigestValue.getBytes(Charset.forName("UTF-8"))))
    digestValue
  }
}
