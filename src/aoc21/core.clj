(ns aoc21.core
  (:require [clojure.string :as s])
  (:gen-class))

(def report-data
  (map #(Integer/parseInt %)
       (s/split-lines
        (slurp "resources/day1-input.txt"))))

(defn depth-increases
  "Return depths increases"
  [xs]
  (map #(- (second %) (first %)) (partition 2 1 xs)))

(defn count-the-positives
  "Count just positive elements of the sequence"
  [xs]
  (count (filter pos? xs)))

(defn sweep-the-data
  "Count positive results of sonar discrimination"
  [xs]
  (count-the-positives (depth-increases xs)))

(defn sum-sliding-windows-by-3
  "Return sums of sliding windows with length 3"
  [xs]
  (map #(reduce + %) (partition 3 1 xs)))

(defn sweep-the-windows
  "Count positive results of sonar window discrimination"
  [xs]
  (count-the-positives (depth-increases (sum-sliding-windows-by-3 xs))))

(defn -main
  "Day 1: Sonar Sweep"
  [& args]
  (println (str "Part 1: " (sweep-the-data report-data)))
  (println (str "Part 2: " (sweep-the-windows report-data))))
