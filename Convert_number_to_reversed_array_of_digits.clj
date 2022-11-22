(ns digitizer.core)

(defn digitize [n]
  (->> n
       str
       reverse
       (map #(Character/digit % 10))))
