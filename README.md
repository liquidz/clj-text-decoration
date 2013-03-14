# text-decoration

Text decoration library

## Usage

leiningen
```clojure
[clj-text-decoration "0.0.2"]
```

```clojure
(use text-decoration)

(doseq [decoration-fn [black red green yellow blue magenta cyan white
                       bg-black bg-red bg-green bg-yellow bg-blue bg-magenta bg-cyan bg-white
                       (comp red bg-blue) (comp bold cyan bg-blue)
                       bold underline italic inverse strikethrough]]
  (println (decoration-fn "The quick brown fox jumps over the lazy dog.")))
```

## License

Copyright (C) 2013 Masashi Iizuka([@uochan](http://twitter.com/uochan/))

Distributed under the Eclipse Public License, the same as Clojure.
