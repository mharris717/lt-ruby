(ns lt.objs.langs.ruby
  (:require [lt.object :as object]

            [lt.objs.langs.ruby.client :as client]
            [lt.objs.langs.ruby.config :as config]
            [lt.objs.langs.ruby.eval :as eval]
            [lt.objs.langs.ruby.image :as image]
            [lt.objs.langs.ruby.live :as live]
            [lt.objs.langs.ruby.watch :as watch]))


(object/object* ::ruby-lang
                :tags #{:ruby.lang})

(def ruby (object/create ::ruby-lang))



