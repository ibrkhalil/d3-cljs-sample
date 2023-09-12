(ns d3.app
  (:require [d3.views :as views]
            [reagent.core :as reagent]
            ["react-dom/client" :as react-dom-client]))

(defn ^:export init []
  (-> (react-dom-client/createRoot (js/document.getElementById "app"))
      (.render (reagent/as-element [views/main]))))
