package monitor

import com.timgroup.statsd.{NonBlockingStatsDClient, StatsDClient}

object DataDogCalls {
  private final val statsd: StatsDClient = new NonBlockingStatsDClient("", "localhost", 8125, Array[String]("tag:value"))
  def logSuccess() {statsd.incrementCounter("message.successes")}
  def logFailure() {statsd.incrementCounter("message.failures")}
  def logErrorType(code: Int) {statsd.recordHistogramValue("error.type", code)}
  def incCount(s:String) {statsd.incrementCounter(s)}

}