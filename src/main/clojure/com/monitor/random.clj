(ns com.monitor.random
  (:gen-class
    :name com.monitor.random
    :methods [#^{:static true} [binomial [int int] double]
              #^{:static true} [printbinomial [int int] void]]))

(defn binomial
  "Calculate the binomial coefficient."
  [n k]
  (let [a (inc n)]
    (loop [b 1
           c 1]
      (if (> b k)
        c
        (recur (inc b) (* (/ (- a b) b) c))))))

(defn printbinomial
  "print out the binomial coefficient -- return nothing."
  [n k]
  (println (binomial n k))
  )

(defn -printbinomial
  "A Java-callable wrapper to allow printing of 'binomial' from clojure."
  [n k]
  (printbinomial n k))

(defn -binomial
  "A Java-callable wrapper around the 'binomial' function."
  [n k]
  (binomial n k))

(defn -main []
  (println (str "(binomial 5 3): " (binomial 5 3)))
  (println (str "(binomial 10042 111): " (binomial 10042 111)))
  )