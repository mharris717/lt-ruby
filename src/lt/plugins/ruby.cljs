(ns lt.objs.langs.ruby
  (:require [lt.object :as object]

            [lt.objs.langs.ruby.client :as client]
            [lt.objs.langs.ruby.config :as config]
            [lt.objs.langs.ruby.eval :as eval]
            [lt.objs.langs.ruby.image :as image]
            [lt.objs.langs.ruby.live :as live]
            [lt.objs.langs.ruby.watch :as watch])

  (:require-macros [lt.macros :refer [behavior]]))

(client/build)
(config/build)
(eval/build)
(image/build)
(live/build)
(watch/build)

(object/->behavior :lt.objs.langs.ruby.eval/on-eval)

(object/object* ::ruby-lang
                :tags #{:ruby.lang})

(def ruby (object/create ::ruby-lang))

(behavior ::ruby-exe
                  :triggers #{:object.instant}
                  :desc "Ruby: Set the path to the ruby executable for clients"
                  :type :user
                  :params [{:label "path"
                            :type :path}]
                  :exclusive true
                  :reaction (fn [this exe]
                              (object/merge! ruby {:lt.objs.langs.ruby.client/ruby-exe exe})))


(behavior ::use-rvm
            :triggers #{:object.instant}
            :desc "Ruby: Use RVM when loading REPL"
            :type :user
            :exclusive true
            :reaction (fn [this]
                        (object/merge! ruby {:lt.objs.langs.ruby.client/use-rvm? true})))


(behavior ::rvm-path
            :triggers #{:object.instant}
            :desc "Ruby: Path to RVM init script"
            :type :user
            :params [{:label "path", :type :path}]
            :exclusive true
            :reaction (fn [this path]
                        (object/merge! ruby {:lt.objs.langs.ruby.client/rvm-path path})))

(behavior ::use-rbenv
            :triggers #{:object.instant}
            :desc "Ruby: Use rbenv when loading REPL"
            :type :user
            :exclusive true
            :reaction (fn [this]
                        (object/merge! ruby {:lt.objs.langs.ruby.client/use-rbenv? true})))

(behavior ::client-enable-logging
            :triggers #{:object.instant}
            :desc "Ruby: log ruby client output to lt_client.log"
            :type :user
            :exclusive true
            :reaction (fn [this]
                        (object/merge! ruby {:lt.objs.langs.ruby.client/enable-client-logging? true})))

