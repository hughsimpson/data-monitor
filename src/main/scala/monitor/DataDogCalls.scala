package monitor

import com.timgroup.statsd.{NonBlockingStatsDClient, StatsDClient}
import akka.actor.ActorRef

object DataDogCalls {
  private final val statsd: StatsDClient = new NonBlockingStatsDClient("", "localhost", 8125, Array[String]("tag:value"))
  def logSuccess() {statsd.incrementCounter("message.successes")}
  def logContent(cont:Any) {cont match {
    case i:Int if 150 < i && i<200 => statsd.incrementCounter("message.between150And200")
    case i:Int => statsd.incrementCounter("message.otherNumber")
    case i:String => statsd.incrementCounter("message.UnknownString")
    case (sender: ActorRef, i: Int) => statsd.recordHistogramValue("message.fromTuple",i)
    case x => statsd.incrementCounter(s"message.${x.getClass.toString}")
  }}
  def logFailure() {statsd.incrementCounter("message.failures")}
  def logErrorType(code: Int) {statsd.recordHistogramValue("error.type", code)}
  def incCount(s:String) {statsd.incrementCounter(s)}

}