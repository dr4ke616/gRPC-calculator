load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library", "scala_binary")  # noqa

scala_library(  # noqa
    name="client",
    srcs=[
        "CalculatorClient.scala",
    ],
    deps=[
        "//calculator/proto:calculator_scala_proto",
    ],
    visibility=["//visibility:public"],
)

scala_binary(  # noqa
    name="run_client",
    srcs=["Main.scala"],
    deps=[
        ":client",
        "//calculator/proto:calculator_scala_proto",
    ],
    runtime_deps=[],
    main_class="client.Main",
    visibility=["//visibility:public"],
)
