(ns lt.objs.langs.ruby.macros)


(defn- namify [type keyword]
  (symbol (str "__" type "__" (.replace (name keyword) "." "__DOT__"))))


(defmacro my-behavior [name & {:keys [reaction] :as r}]
  (if (and (seq? reaction) (= 'fn (first reaction)))
    (let [[_ args & body] reaction]
      `(do
         (defn ~(namify "BEH" name) ~args ~@body)
         (lt.object/behavior* ~name ~@(apply concat (assoc r :reaction (namify "BEH" name))))))
    `(lt.object/behavior* ~name ~@(apply concat r))))
