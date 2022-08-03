package demo

import dates.DateUtils.oldToNewDate
import dates.LegacyDate
import logging.Logger
//import logging.db.LogDefaults._
import payments.LegacyPayment
import payments.PaymentDefaults.ModernPayment
import logging.file.LogDefaults._

object Program {
  def showLogging(input: String)(implicit logger: Logger): Unit = {
    println("--- Working with logs ---")
    logger.log(input)
  }

  def showDates(): Unit = {
    println("--- Working with dates ---")
    val date = new LegacyDate("25/12/2021")
    date.legacy1()
    date.legacy2()
    date.modern1()
    date.modern2()
  }
  def showPayments(): Unit = {
    println("--- Working with payments ---")
    val payment = new LegacyPayment(30000.0)
    val payment1 = new ModernPayment(payment)
    payment.legacy1()
    payment.legacy2()
    payment.modern1()
    payment.modern2()
    payment1.modern1()
  }

  def main(args: Array[String]): Unit = {
    showLogging("Live long and prosper")
    showDates()
    showPayments()
  }
}
