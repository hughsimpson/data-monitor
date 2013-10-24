(ns com.monitor.statsdCalls
  (:gen-class
    :name com.monitor.statsdCalls
    :methods [;#^{:static true} [incCount [str] void]
              #^{:static true} [logSuccess [] void]]
    ))

(defn logSuccess
  "Log the call to the 'receiveMessage' method in any ActoCell."
  []

  )