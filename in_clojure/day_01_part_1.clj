(require '[clojure.string :as str])

(defn mass->fuel [mass]
  (- (quot mass 3) 2))

(defn fuel-total []
  (->> (str/split (slurp "../inputs/day01.txt") #"\n")
       (map read-string)
       (map mass->fuel)
       (apply +)
       (str "Day 01 - Part 1: ")
       (println)))

(fuel-total)
