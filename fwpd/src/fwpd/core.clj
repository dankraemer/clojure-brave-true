(ns fwpd.core)

(def filename "suspects.csv")

(slurp filename)

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name          identity
                  :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(convert :glitter-index "3")

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(parse (slurp filename))

(defn mapify
  "Return a seq of maps like {:name \"Eduard Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(first (mapify (parse (slurp filename))))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(glitter-filter 3 (mapify (parse (slurp filename))))


;; Exercise 1

(def glitter-filter-result
  (glitter-filter 3 (mapify (parse (slurp filename)))))

(map :name glitter-filter-result)

;; Exercise 2

(defn append
  [suspects new-suspect]
  (into suspects new-suspect))

(append {:a 1 :b 2} {:c 3})

;; Exercise 3

(defn validate
  [suspect]
  (and (:name suspect)
        (:glitter-index suspect)
        suspect) )

(def suspect-ok {:name "daniel" :glitter-index 12})
(def suspect-bad {:name "leniad"})

(validate suspect-ok)

(defn new-append
  [suspects new-suspect]
  (if (validate new-suspect)
    (into suspects new-suspect)
    suspects))

(new-append {} suspect-ok)
(new-append {} suspect-bad)

;; Exercise 4

(defn vectorize
  [{:keys [name glitter-index]}]
  (conj [] name glitter-index))

(vectorize suspect-ok)

(defn csv-maker
  [{:keys [name glitter-index]}]
  (clojure.string/join ","
                       (conj [] name glitter-index)))

(csv-maker suspect-ok)
(map csv-maker glitter-filter-result)

(defn csv-serializer
  [suspects]
  (clojure.string/join "\n"
                       (map csv-maker suspects)))

(csv-serializer glitter-filter-result)

