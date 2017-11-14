load("@io_bazel_rules_scala//scala:scala.bzl", "scala_library")  # noqa

scala_library(  # noqa
    name="server",
    srcs=[
        "HelloWorldServer.scala",
    ],
    deps=[
        "//grpctest/proto:helloworld_scala_proto",
    ],
    visibility=["//visibility:public"],
)
