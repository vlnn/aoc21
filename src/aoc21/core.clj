(ns aoc21.core
  (:require [clojure.string :as str])
  (:gen-class))

(def diagnostic-data
  (apply map vector (map char-array (str/split-lines (slurp "resources/input.txt")))))

(defn gamma-rate
  [data]
  ({false 0, true 1} (< (second (apply map vector (vec (frequencies (first data))))))))

(defn -main
  "Day 3: Binary Diagnostic"
  [& args]
  (println "Hello, World!"))
