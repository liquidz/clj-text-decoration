# text-decoration

Text decoration library for color and style in the terminal

Uses [ANSII escape codes](https://en.wikipedia.org/wiki/ANSI_escape_code#SGR_parameters) to set the color and style (such as bold) of the text
that is going to be printed to the terminal, exposing these as nicely named functions such as `bold`.
## Usage

leiningen
```clojure
[clj-text-decoration "0.0.2"]
```

```clojure
(ns foo
  (:require [text-decoration.core :refer :all]))

(defn -main
  []
  (doseq [decoration-fn [black red green yellow blue magenta cyan white
                         bg-black bg-red bg-green bg-yellow bg-blue bg-magenta bg-cyan bg-white
                         (comp red bg-blue) (comp bold cyan bg-blue)
                         bold underline italic inverse strikethrough]]
    (println (decoration-fn "The quick brown fox jumps over the lazy dog."))))
```

## License

Copyright (C) 2014 Masashi Iizuka([@uochan](http://twitter.com/uochan/))

Distributed under the Eclipse Public License, the same as Clojure.
