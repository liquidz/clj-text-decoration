(ns text-decoration.core-test
  (:require
    [clojure.test         :refer :all]
    [text-decoration.core :refer :all]))

(def ^:const TEXT "The quick brown fox jumps over the lazy dog.")

(deftest a-test
  (testing "foreground"
    (doseq [f [black red green yellow blue magenta cyan white]]
      (-> TEXT f println)))

  (testing "background"
    (doseq [f [bg-black bg-red bg-green bg-yellow bg-blue
               bg-magenta bg-cyan bg-white]]
      (-> TEXT f println)))

  (testing "decoration"
    (doseq [f [bold underline italic inverse strikethrough]]
      (-> TEXT f println))))
