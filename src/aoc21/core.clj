(ns aoc21.core
  (:require [clojure.string :as str]
            [clojure.core.matrix :as matrix])
  (:gen-class))

(def bingo-input
  (map #(Integer/parseInt %) (str/split  (first (str/split-lines (slurp "resources/input.txt"))) #",")))

(def bingo-boards-raw
  (map #(Integer/parseInt %) (filter not-empty (str/split (str/join #" "  (rest (str/split-lines (slurp "resources/input.txt")))) #" "))))

(def bingo-boards
  (matrix/reshape bingo-boards-raw [100 5 5]))

(defn -main
  "Day 4: Giant Squid"
  [& _]
  (println "Found a Giant Squid!"))
