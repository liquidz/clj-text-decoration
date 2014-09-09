(ns text-decoration.core)

(def ^:private color-codes
  {; foreground
   :black   "\033[30m"
   :red     "\033[31m"
   :green   "\033[32m"
   :yellow  "\033[33m"
   :blue    "\033[34m"
   :magenta "\033[35m"
   :cyan    "\033[36m"
   :white   "\033[37m"
   :default "\033[39m"
   ; background
   :bg-black   "\033[40m"
   :bg-red     "\033[41m"
   :bg-green   "\033[42m"
   :bg-yellow  "\033[43m"
   :bg-blue    "\033[44m"
   :bg-magenta "\033[45m"
   :bg-cyan    "\033[46m"
   :bg-white   "\033[47m"
   :bg-default "\033[49m"})

(defn- colorize [color-code s] (str color-code s "\033[0m"))
(defmacro defcolors []
  (cons 'do (for [[k v] color-codes :let [fname (symbol (name k))]]
              `(def ~fname (partial colorize ~v)))))

; =color
(defcolors)

; =decoration
(defn bold          [s] (str "\033[1m" s "\033[22m"))
(defn underline     [s] (str "\033[4m" s "\033[24m"))
(defn italic        [s] (str "\033[3m" s "\033[23m"))
(defn inverse       [s] (str "\033[7m" s "\033[27m"))
(defn strikethrough [s] (str "\033[9m" s "\033[29m"))

; =assoc-color
(defn assoc-color
  "Associate color-function to hash-map

  ex)
    (assoc-color {:a \"AAA\", :b \"BBB\"}
                  :a red
                  :b (comp blue bold))"
  [m & kvs]
  (merge m (into {} (for [[key color-fn] (partition 2 kvs)]
                      [key (color-fn (get m key))]))))

