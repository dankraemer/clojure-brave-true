(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I`m a little teapot"))
(println "Cleanliness is next to godliness")

(defn train []
  "Choo choo")
;; => #'clojure-noob.core/train

(defn train2 []
  "Choo choo 2")
;; => #'clojure-noob.core/train2

(if true
  (do (println "Sucess")
      "By Zeus`s hammer")
  (do (println "Failure")
      "By Aquaman`s trident"))
;; => "By Zeus`s hammer"

(if false
  "By Odin`s Elbow")
;; => nil

(when true
  (println "Success!")
  "Abra Cadabra")
;; => "Abra Cadabra"

(nil? nil)
;; => true

(if "bears eat beets"
  "bears beets Battlestar Galactica")
;; => "bears beets Battlestar Galactica"

(if nil
  "This won`t be the result because nil is falsey"
  "nil is falsey")
;; => "nil is falsey"

(or false nil :large_I_meant_venti :why_cant_I_just_say_large)
;; => :large_I_meant_venti

(or (= 0 1)
    (= "yes" "no"))
;; => false

(or nil)

(and :free_wifi :hot_cofee)

(and :feeling_super_cool nil false)

(def failed-protagonist-names
  ["Larry Poter" "Doreen the Explorer" "The Incredible Bulk"])

(defn error-message
  [severity]
  (str "OH MY GOD! IT`S A DISASTER! WE`RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED"
         "DOOOOOOOMED")))

(def his-name "Chewbacca")
(str "\"Uggglgldflglglglll\" - " his-name)

;; Maps

{:first-name "Charlie"
 :last-name "McFishwich"}

{"string-key" +}

{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}

(hash-map :a 1 :b 2)

(get {:a 0 :b 1} :b)

(get {:a 0 :b {:c "ho hum"}} :b)

(get {:a 0 :b 1} :c)

(get {:a 0 :b 1} :c "unicorns?")

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])

({:name "Daniel"} :name)

(:name {:name "Daniel"})

(:a {:a 1 :b 2 :c 3})

(:d {:a 1 :b 2 :c 3} "No gnome knows homes like Noah knows")

;; Vectors

[3 2 0]

(get [3 2 1] 0)

(def mixed-array
  ["a" {:name "Pugsley Winterbotton"} "c"])

(get mixed-array 0)
(get mixed-array 1)
(get mixed-array 2)

(vector "creepy" "full" "moon")

(conj [0 1 2 3] 4 5 6)

;; Lists

'(0 1 2 3 4)

(nth '(:a :b :c) 0)

(nth '(:a :b :c) 2)

(list 1 "two" {3 4})

(conj '(1 2 3) 4)

;; Sets (Unique values)

#{"kurt vonnegut" 20 :icicle }

(hash-set 1 1 2 2)

(conj #{:a :b} :b)

(set [1 2 3 3 3 4 4])

(def set-test
  #{:a 2 "three" :d nil})

(contains? set-test :a)
(contains? set-test "three")
(contains? set-test 3)
(contains? set-test nil) ;; returns true. Better option to test for set membership

(get set-test :a)
(get set-test "three")
(get set-test 3)
(get set-test nil) ;; returns nil. A bit weird.

(:a set-test)
(:d set-test)

;; Functions

((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)

((first [+ 0]) 1 2 3)

(inc 1.1)

(map inc [0 1 2 3])

(+ (inc 199) (/ 100 (- 7 2)))

(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH MY GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "zelda")
(doc too-enthusiastic)

(defn x-chop ;; Arity overloading
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kayne West" "slap")
(x-chop "Kayne West")


(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn! " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "Billy" "Anne-Marie" "The Incredible Bulk")

(defn favorite-things
  [name & things] ;; things is a list
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")

(defn my-first
  [[first-thing]]
  first-thing)

(my-first ["oven" "bike" "war-axe"])

(defn chooser ;; Destructure a Vector
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade" "Handsome Jack" "Pigpen" "Aquaman"])


(defn announce-treasure-location
  [{lat :lat lng :lng}] ;; Destructure a Map
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})

(defn announce-treasure-location2
  [{:keys [lat lng] :as treasure-location}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng))
  (prn treasure-location))

(announce-treasure-location2 {:lat 28.22 :lng 81.33})

(defn ilustrative-func
  []
  (+ 1 304)
  30
  "joe")

(ilustrative-func)

(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number is OK I guess"))

(number-comment 5)
(number-comment 8)

;; Anonymous functions

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Mr Magoo"])

((fn [x] (* 3 x)) 8)

(def my-special-multiplier (fn [x] (* 3 x)))

(my-special-multiplier 12)

(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Darth Vader" "Mr Magoo"])

(#(str %1 " and " %2) "cornbread" "butter beans")

(#(identity %&) 1 "blarg" :yip)

;; Returning functions

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)

;; The Hobbit

(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part {:name "left-ear" :size 4})

(defn symetrize-body-part
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symetrize-body-part asym-hobbit-body-parts)

;; let

(let [x 3]
  x)

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])

(let [[pongo] (take 2 dalmatian-list)]
  pongo)

(def x 0)
(let [x 1] x)       ;; x has local scope
(let [x (inc x)] x) ;; x can reference global scope

(into [] (set [ :a :a]))

;; Loop

(loop [iteration 0]
  (println (str "Iteration: " iteration))
  (if (> iteration 3)
    (println "Good bye!")
    (recur (inc iteration))))

(defn recursive-printer
  ([]
     (recursive-printer 0))
  ([iteration]
     (println iteration)
     (if (> iteration 3)
       (println "Goodbye!")
       (recursive-printer (inc iteration)))))

(recursive-printer)
(recursive-printer 0)
(recursive-printer -3)

;; Regular Expressions

#"regular-expression"

(re-find #"^left-" "left-eye")

(re-find #"^left-" "cleft-chin")

(re-find #"^left-" "wongleblart")

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(matching-part {:name "left-ear" :size 3})
(matching-part {:name "head" :size 5})

;; Reduce

(reduce + [1 2 3 4])

(reduce + 15 [1 2 3 4]) ;; 15 is an optional initial value

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(my-reduce + [1 2 3 4])
(my-reduce + 15 [1 2 3 4])

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])) )
          []
          asym-body-parts))

(better-symmetrize-body-parts asym-hobbit-body-parts)

;; Hobbit violence

(map :size asym-hobbit-body-parts)


(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size asym-body-parts))
        target (rand body-part-size-sum)]
      (loop [[part & remaining] sym-parts
             accumulated-size (:size part)]
        (if (> accumulated-size target)
          part
          (recur remaining (+ accumulated-size (:size (first remaining)))))  )))

(hit asym-hobbit-body-parts)

;; Exercises

;; EXERCISE 1

(def my-name "Daniel")
(str "My name is: " my-name)

(vector :1 2 "three")

(list :1 2 "three")

(hash-map :a 1 :b 2 :c "three")

(hash-set :a 1 :b 2 :c "three")

;; EXERCISE 2

(defn add100
  [num]
  (+ num 100))

(add100 47)

;; EXERCISE 3

(defn dec-maker
  "Create a custom decrementor"
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))
(dec9 10)

;; EXERCISE 3

(defn mapset
  [f coll]
  (set (map f coll)))

(set (map inc [1 1 2 2]))

(mapset inc [1 1 2 2])

;; EXERCISE 4


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(comment
  (time  (-main))
  (train)
  (train2)
  (error-message :mild)
  (error-message :doom)
  failed-protagonist-names
  93
  1.2
  1/5
  (+ 1 2))
