(ns lt.objs.langs.ruby
  (:require [lt.object :as object]
            [lt.objs.eval :as eval]
            [lt.objs.console :as console]
            [lt.objs.command :as cmd]
            [lt.objs.clients.tcp :as tcp]
            [lt.objs.sidebar.clients :as scl]
            [lt.objs.dialogs :as dialogs]
            [lt.objs.files :as files]
            [lt.objs.popup :as popup]
            [lt.objs.platform :as platform]
            [lt.objs.editor :as ed]
            [lt.objs.editor.pool :as pool]
            [lt.objs.plugins :as plugins]
            [lt.plugins.watches :as watches]
            [lt.objs.proc :as proc]
            [clojure.string :as string]
            [lt.objs.clients :as clients]
            [lt.objs.notifos :as notifos]
            [lt.util.load :as load]
            [crate.binding :refer [bound subatom]]
            [crate.core :as crate]
            [lt.util.dom :as dom]
            [lt.util.cljs :refer [js->clj]]

            [lt.objs.langs.ruby.client :as client :refer [shell rb-path runner-path]])

  (:require-macros [lt.macros :refer [behavior defui]]))


;;****************************************************
;; Proc
;;****************************************************



;;****************************************************
;; Eval
;;****************************************************

(defn try-connect [{:keys [info]}]
  (let [path (:path info)
        client (clients/client! :ruby.client)]
    (check-all {:path path
                :client client})
    client))












(behavior ::ruby-printer
                  :triggers #{:editor.eval.ruby.print}
                  :reaction (fn [editor p]
                              (console/loc-log {:file (files/basename (:file p))
                                                :line "stdout"
                                                :content (:msg p)})))



(behavior ::connect
                  :triggers #{:connect}
                  :reaction (fn [this path]
                              (try-connect {:info {:path path}})))


(object/object* ::ruby-lang
                :tags #{:ruby.lang})

(def ruby (object/create ::ruby-lang))

(scl/add-connector {:name "Ruby"
                    :desc "Select a directory to serve as the root of your ruby project."
                    :connect (fn []
                               (dialogs/dir ruby :connect))})





(behavior ::client-enable-logging
            :triggers #{:object.instant}
            :desc "Ruby: log ruby client output to lt_client.log"
            :type :user
            :exclusive true
            :reaction (fn [this]
                        (object/merge! ruby {::enable-client-logging? true})))
