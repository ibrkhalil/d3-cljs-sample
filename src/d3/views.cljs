(ns d3.views
  (:require ["d3" :as d3]))

(defonce svg (-> d3
                 (.select "#chart-area")
                 (.append "svg")
                 (.attr "width" 400)
                 (.attr "height" 400)))

(defn main []
  (let [scale-fn (-> (d3/scaleLinear)
                     (.domain #js [0 828])
                     (.range #js [0 400]))
        _data    (-> (d3/json "js/buildings.json")
                     (.then (fn [data]
                              (-> svg
                                  (.selectAll "rect")
                                  (.data data)
                                  .enter
                                  (.append "rect")
                                  (.attr "y" 0)
                                  (.attr "x" (fn [_elem idx] (* idx 60)))
                                  (.attr "width" 40)
                                  (.attr "height" (fn [elem] (scale-fn (js/Number (get (js->clj elem) "height")))))
                                  (.attr "fill" "gray")))))]))
