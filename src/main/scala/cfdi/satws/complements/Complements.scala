package cfdi.satws.complements

import akka.http.scaladsl.common.StrictForm.FileData

trait Complements {
  def changeDateWithTheCorrectFormat(date: String): String
  def extractFileData(fileData: FileData): Array[Byte]
  def getDigestValue(messageDigestValue: String): String
}
