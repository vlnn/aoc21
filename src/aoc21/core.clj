(ns aoc21.core
  (:require [clojure.string :as str])
  (:gen-class))

(def diagnostic-data
  (apply map vector (map char-array (str/split-lines (slurp "resources/input.txt")))))

(defn gamma-rate
  [data]
  (key (first
        (sort-by val > (frequencies  data)))))

(defn epsilon-rate
  [data]
  (key (first
        (sort-by val < (frequencies  data)))))

(defn count-whole-rate
  [data f]
  (Integer/parseInt (str/join (map f data)) 2))

(def gamma
  (count-whole-rate diagnostic-data gamma-rate))

(def epsilon
  (count-whole-rate diagnostic-data epsilon-rate))

(defn -main
  "Day 3: Binary Diagnostic"
  [& args]
  (println "gamma rate: " gamma)
  (println "epsilon rate: " epsilon)
  (println "power: " (* gamma epsilon)))
