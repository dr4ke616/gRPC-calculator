load("@io_bazel_rules_scala//scala:scala.bzl", "scala_binary")  # noqa

scala_binary(  # noqa
    name="helloworld",
    srcs=["Main.scala"],
    deps=[
        "//grpctest/scala/helloworld/server",
        "//grpctest/scala/helloworld/client",
        "//grpctest/proto:helloworld_scala_proto",
    ],
    runtime_deps=[
    ],
    main_class="helloworld.Main",
    visibility=["//visibility:public"],
)
