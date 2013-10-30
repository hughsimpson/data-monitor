package monitor

import com.timgroup.statsd.{NonBlockingStatsDClient, StatsDClient}
import scala.util.Try
import scala.math.random

object DataDogCalls {
  private final val statsd: StatsDClient = new NonBlockingStatsDClient("", "localhost", 8125, Array[String]("tag:value"))
  def logSuccess() {statsd.incrementCounter("message.successes")}
  def logFailure() {statsd.incrementCounter("message.failures")}
  def logErrorType(code: Int) {statsd.recordHistogramValue("error.type", code)}
  def incCount(s:String) {statsd.incrementCounter(s)}
  def gauge(i:Any) {
    println("£@%£TG")
    i match {
    case x:Int => Try(statsd.gauge("to.gauge", 1, (x % 5).toString) )
    case x:java.lang.Integer => Try(statsd.gauge("to.gauge", 1, (x % 5).toString) )
    case _ =>  Try(statsd.gauge("to.gauge", 1, "toto") ) ; Try(statsd.gauge("to.gauge", 1, (random * 5).round.toString ))
  }}

}