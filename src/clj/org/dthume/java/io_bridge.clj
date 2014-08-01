(ns org.dthume.java.io-bridge
  (:import [org.dthume.java.io_bridge BridgedOutputStream OutputStreamSink]))

(defn bridged-output-stream
  "Create a new bridged output stream. `f` must implement OutputStreamSink"
  ^BridgedOutputStream [^OutputStreamSink f]
  (BridgedOutputStream. f))

(defn bridged-result
  "Get the result of this BridgeOutputStream, if any."
  [^BridgedOutputStream b]
  (when b (.getResult b)))
