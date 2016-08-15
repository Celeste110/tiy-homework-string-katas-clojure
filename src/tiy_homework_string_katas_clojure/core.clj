(ns tiy-homework-string-katas-clojure.core)
(require '[clojure.string :as str])

;; Given a string, return a new string where spaces have been inserted between each letter.
;; Do not include any additional spaces before the first character or after the last character.
(defn explode [a]
  (clojure.string/trim (clojure.string/replace a #"" " "))
  )
;; Given a string, return a new string where "not " has been added to the front. However, if
;; the string already begins with "not", return the string unchanged.
(defn notString [a]
  (if (>= (count a) 3)
    (if (= (subs a 0 3) "not")
      a
      (str "not " a)
      )
    (str "not " a)))

;; Given a non-empty string and an integer, return a new string where the character at the specified
;; index has been removed. The specified index will be a valid index in the original string.
(defn missingChar [a, i]
  (str (subs a 0 i) (subs a (+ i 1) (count a)))
  )

;; Given a string, return a new string where the first and last characters have been exchanged.
(defn frontBack [a]
  (if (> (count a) 1)

    (str (subs a (- (count a) 1) (count a)) (subs a 1 (- (count a) 1)) (subs a 0 1))
    a))

;; Given a string, we'll say that the front is the first 3 characters of the string. If the string
;; length is less than 3, the front is whatever is there. Return a new string which is 3 copies of the front.
(defn front3 [a]
  (if (>= (count a) 3)
    (str (subs a 0 3) (subs a 0 3) (subs a 0 3))
    (str a a a)
    )
  )

;; Given a string, take the last character and return a new string with the last character added at the
;; front and back, so "cat" yields "tcatt". The original string will be length 1 or more.
(defn backAround [a]
  (if (>= (count a) 2)
    (str (subs a (- (count a) 1) (count a)) (subs a 0 (count a)) (subs a (- (count a) 1)))
    a
    )
  )
;; Given a string, take the first 2 characters and return the string with the 2 characters added at both
;; the front and back, so "kitten" yields"kikittenki". If the string length is less than 2, use whatever
;; characters are there.
(defn front22 [a]
  (if (> (count a) 2)
    (str (subs a 0 2) (subs a 0 (count a)) (subs a 0 2))
    (str a a a)
    )
  )
;; Given a string, if the string "del" appears starting at index 1, return a string where that "del"
;; has been deleted. Otherwise, return the string unchanged.
(defn delDel [a]
  (if (= (subs a 1 4) "del")
    (str (subs a 0 1) (subs a 4 (count a)))
    a
    )
  )
;; Given a string, return a string made of the first 2 characters (if present), however include first
;; char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz".
(defn startOz [a]

  (if (= (subs a 0 2) "oz")
    "oz"
    (if (= (subs a 0 1) "o")
      "o"
      (if (= (subs a 1 2) "z")
        "z"
        (if (>= (count a) 2)
          (subs a 0 2)
          )
        )
      )
    )
  )

;; Given a string, return a new string where the last 3 characters are now in upper case. If the
;; string has less than 3 characters, uppercase whatever is there.
(defn endUp [a]
  (if (>= (count a) 3)
    (str (subs a 0 (- (count a) 3)) (str/upper-case (subs a (- (count a) 3) (count a))))
    (str/upper-case a)
    )
  )

(defn -main []
  ;; 1. call explode
  (print "(explode \"example\") -> ")
  (println (explode "example"))
  (print "(explode \"cat\") -> ")
  (println (explode "cat"))
  (print "(explode \"\") -> ")
  (println (explode ""))
  (print "(explode \"c\") -> ")
  (println (explode "c"))
  (print "(explode \"d\") -> ")
  (println (explode "d"))
  (print "(explode \"map\") -> ")
  (println (explode "map"))
  (print "(explode \"art\") -> ")
  (println (explode "art"))

  ;; 2. call notString
  (print "\n(notString \"candy\") -> ")
  (println (notString "candy"))
  (print "(notString \"x\") -> ")
  (println (notString "x"))
  (print "(notString \"not bad\") -> ")
  (println (notString "not bad"))
  (print "(notString \"chocolate\") -> ")
  (println (notString "chocolate"))
  (print "(notString \"vanilla bean\") -> ")
  (println (notString "vanilla bean"))
  (print "(notString \"not candy\") -> ")
  (println (notString "not candy"))

  ;; 3. call missingChar
  (print "\n(missingChar \"kitten\", 1) -> ")
  (println (missingChar "kitten" 1))
  (print "(missingChar \"kitten\", 0) -> ")
  (println (missingChar "kitten" 0))
  (print "(missingChar \"kitten\", 4) -> ")
  (println (missingChar "kitten" 4))
  (print "(missingChar \"marbles\", 2) -> ")
  (println (missingChar "marbles" 2))
  (print "(missingChar \"project\", 3) -> ")
  (println (missingChar "project" 3))
  (print "(missingChar \"glass\", 1) -> ")
  (println (missingChar "glass" 1))

  ;; 4. call frontBack
  (print "\n(frontBack \"code\") -> ")
  (println (frontBack "code"))
  (print "(frontBack \"a\") -> ")
  (println (frontBack "a"))
  (print "(frontBack \"ab\") -> ")
  (println (frontBack "ab"))
  (print "(frontBack \"light\") -> ")
  (println (frontBack "light"))
  (print "(frontBack \"apple\") -> ")
  (println (frontBack "apple"))
  (print "(frontBack \"table\") -> ")
  (println (frontBack "table"))

  ;; 5. call frontThree
  (print "\n(front3 \"Java\") -> ")
  (println (front3 "Java"))
  (print "(front3 \"Chocolate\") -> ")
  (println (front3 "Chocolate"))
  (print "(front3 \"abc\") -> ")
  (println (front3 "abc"))
  (print "(front3 \"Katherine\") -> ")
  (println (front3 "Katherine"))
  (print "(front3 \"Hannah\") -> ")
  (println (front3 "Hannah"))
  (print "(front3 \"Michael\") -> ")
  (println (front3 "Micheal"))

  ;; 6. call backAround
  (print "\n(backAround \"cat\") -> ")
  (println (backAround "cat"))
  (print "(backAround \"Hello\") -> ")
  (println (backAround "Hello"))
  (print "(backAround \"a\") -> ")
  (println (backAround "a"))
  (print "(backAround \"Computer\") -> ")
  (println (backAround "Computer"))
  (print "(backAround \"pen\") -> ")
  (println (backAround "pen"))
  (print "(backAround \"Sidewalk\") -> ")
  (println (backAround "Sidewalk"))

  ;; 7. call front22
  (print "\n(front22 \"kitten\") -> ")
  (println (front22 "kitten"))
  (print "(front22 \"Ha\") -> ")
  (println (front22 "Ha"))
  (print "(front22 \"abc\") -> ")
  (println (front22 "abc"))
  (print "(front22 \"xyz\") -> ")
  (println (front22 "xyz"))
  (print "(front22 \"bin\") -> ")
  (println (front22 "bin"))
  (print "(front22 \"bear\") -> ")
  (println (front22 "bear"))

  ;; 8. call deleteDel
  (print "\n(delDel \"adelbc\") -> ")
  (println (delDel "adelbc"))
  (print "(delDel \"adelHello\") -> ")
  (println (delDel "adelHello"))
  (print "(delDel \"adedbc\") -> ")
  (println (delDel "adedbc"))
  (print "(delDel \"ndelcamp\") -> ")
  (println (delDel "ndelcamp"))
  (print "(delDel \"random\") -> ")
  (println (delDel "random"))
  (print "(delDel \"zdelsight\") -> ")
  (println (delDel "zdelsight"))

  ;; 9. call startOz
  (print "\n(startOz \"ozymandias\") -> ")
  (println (startOz "ozymandias"))
  (print "(startOz \"bzoo\") ->  ")
  (println (startOz "bzoo"))
  (print "(startOz \"oxx\") -> ")
  (println (startOz "oxx"))
  (print "(startOz \"kitten\") -> ")
  (println (startOz "kitten"))
  (print "(startOz \"omega\") -> ")
  (println (startOz "omega"))
  (print "(startOz \"oz\") -> ")
  (println (startOz "oz"))
  (print "(startOz \"marvel\") -> ")
  (println (startOz "marvel"))

  ;; 10. call endUp
  (print "\n(endUp \"Hello\") -> ")
  (println (endUp "Hello"))
  (print "(endUp \"hi there\") -> ")
  (println (endUp "hi there"))
  (print "(endUp \"hi\") -> ")
  (println (endUp "hi"))
  (print "(endUp \"capitals\") -> ")
  (println (endUp "capitals"))
  (print "(endUp \"state\") -> ")
  (println (endUp "state"))
  (print "(endUp \"method\") -> ")
  (println (endUp "method"))

  )

(-main)