(require '[clojure.string :as str])

(defn required-fuel
  ([mass] (required-fuel mass 0))
  ([mass total]
   (let [fuel (- (quot mass 3) 2)]
     (if (pos-int? fuel)
       (required-fuel fuel (+ fuel total))
       total))))

(defn fuel-total []
		(->> (str/split (slurp "../inputs/day01.txt") #"\n")
		     (map read-string)
		     (map required-fuel)
		     (apply +)
		     (str "Day 01 - Part 2: ")
       (println)))

(fuel-total)
