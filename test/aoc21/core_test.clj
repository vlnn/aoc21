(ns aoc21.core-test
  (:require [clojure.test :refer :all]
            [aoc21.core :as sut]))

(deftest test-count-the-positives
  (testing "How many positives in sequence"
    (is (= 3 (sut/count-the-positives [1 2 0 3 -1 -3])))
    (is (= 0 (sut/count-the-positives [0 -2.4 -1 -3])))
    (is (= 0 (sut/count-the-positives [])))))

(deftest test-depth-increases
  (testing "How depths's increases are calculated"
    (is (=  () (sut/depth-increases [])))
    (is (= [0] (sut/depth-increases [1 1])))
    (is (= [0 1] (sut/depth-increases [1 1 2])))
    (is (= [0 0 -1] (sut/depth-increases [1 1 1 0])))))
