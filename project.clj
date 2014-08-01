(defproject org.dthume/java.io-bridge "0.1.0-SNAPSHOT"
  :description "Java bridge for implementing input / output streams without proxy"

  :dependencies [[org.clojure/clojure "1.6.0"]]
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  
  :javac-options ["-target" "1.6" "-source" "1.6"]

  :aliases
  {"ci-build"
   ^{:doc "Perform CI build"}
   ["do" ["clean"] ["check"] ["compile"]]

   "dev-install"
   ^{:doc "Perform local install"}
   ["do" ["clean"] ["check"] ["compile"] ["install"]]})
