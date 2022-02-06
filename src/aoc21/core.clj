(ns aoc21.core
  (:require [clojure.string :as str])
  (:gen-class))

(def course-data
  "Provide data for course as vector of commands followed by vector of values"
  (str/split-lines (slurp "resources/input.txt")))

(defrecord Coords
    [horizontal,
     depth,
     aim])

(defn create-coords
  [h d a]
  (->Coords
   h d a))

(defn update-coords
  "Generate new coordinates of the submarine"
  [current-coords command value]
  (case command
    "forward" (create-coords  (+ (:horizontal current-coords) value)
                              (+ (:depth current-coords) (* (:aim current-coords) value))
                              (:aim current-coords))
    "down"    (create-coords (:horizontal current-coords)
                             (:depth current-coords)
                             (+ (:aim current-coords) value))
    "up"      (create-coords (:horizontal current-coords)
                             (:depth current-coords)
                             (- (:aim current-coords) value))))

(defn read-commands
  "Return pair of command string and integer value - and rest of the command seq"
  [xs coordinates]
  (if (seq xs)
    (let [[command valstr]
          (str/split (first xs) #" ")
          updated-coords
          (update-coords coordinates command (Integer/parseInt valstr))]
      (recur (rest xs) updated-coords))
    coordinates))

(defn -main
  "Day 2: Dive!"
  [& args]
  (let [r (read-commands course-data (create-coords 0 0 0))]
    (println (* (:horizontal r) (:depth r)))))
