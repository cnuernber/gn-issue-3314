(ns make-jdk16
    (:require [libc :as libc]
              [tech.v3.datatype.ffi.mmodel :as mmodel]))



(defn make-bindings
  [argmap]
  (.mkdir (java.io.File. "generated-classes"))
    (with-bindings {#'*compile-path* "generated-classes"}
      (mmodel/define-library
        libc/fn-defs
        nil
        {:classname 'libc.JDK16Bindings
         :instantiate? true})))
