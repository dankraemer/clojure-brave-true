(ns chapter-5.core)

;; Functional Programming

;; Pure functions: Referential Transparency

(+ 1 2)

; Referential transparency
(defn wisdom
  [words]
  (str words ", Daniel-san"))

(wisdom "Always bathe on Fridays")

(defn analisys
  [text]
  (str "Character count: " (count text)))

; Not Referential transparency
(defn year-end-evaluation
  []
  (if (> (rand) 0.5)
    "You get a raise"
    "Better luck next year"))

(year-end-evaluation)

(defn analyze-file
  [filename]
  (analisys (slurp filename)))











