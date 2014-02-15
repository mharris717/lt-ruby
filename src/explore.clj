(ns lt.objs.langs.ruby.config
  (:require [lt.object :as object]
            [lt.macros :as macros]))

(macroexpand-1 '(macros/behavior ::use-rvm
            :triggers #{:object.instant}
            :desc "Ruby: Use RVM when loading REPL"
            :type :user
            :exclusive true
            :reaction (fn [this]
                        (object/merge! ruby {:lt.objs.langs.ruby.client/use-rvm? true})))
)
