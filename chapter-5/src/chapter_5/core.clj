(ns chapter-5.core)

; Functional Programming

; Pure functions: Referential Transparency

(+ 1 2)

(defn wisdom
  [words]
  (str words ", Daniel-san"))

(wisdom "Always bathe on Fridays")
