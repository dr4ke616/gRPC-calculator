load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary")  # noqa

scala_library(  # noqa
    name="server",
    srcs=[
        "CalculatorServer.scala",
    ],
    deps=[
        "//grpctest/proto:calculator_scala_proto",
    ],
    visibility=["//visibility:public"],
)

scala_binary(  # noqa
    name="run_server",
    srcs=["Main.scala"],
    deps=[
        ":server",
        "//grpctest/proto:calculator_scala_proto",
    ],
    runtime_deps=[],
    main_class="server.Main",
    visibility=["//visibility:public"],
)
