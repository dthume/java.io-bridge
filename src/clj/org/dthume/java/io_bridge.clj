(ns org.dthume.java.io-bridge
  (:import [org.dthume.java.io_bridge BridgedOutputStream]))

(defn bridged-output-stream
  "Create a new bridged output stream. `f` must be a function providing 3 arities:
1, 2 and 3 args. All of these must return a \"new\" value of `f`.

1. When the stream is closed `f` will be called with a single argument:
   boolean `true`.
2. When the stream is flushed `f` will be called with a single argument:
   boolean `false`.
3. When a single `int` is written to the stream `f` will be called with two
   arguments: boolean `false` and the int.
4. When a subrange of a byte array is written to the stream, `f` will be called
   with 3 arguments: the byte array, the offset and the length."
  ^BridgedOutputStream [f]
  (BridgedOutputStream. f))

(defn bridged-result
  "Get the current `IFn` backing this `BridgedOutputStream`."
  [^BridgedOutputStream b]
  (when b (.getFn b)))
