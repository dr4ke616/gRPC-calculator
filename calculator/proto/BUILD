package(default_visibility=["//visibility:public"])  # noqa

load("@io_bazel_rules_go//proto:def.bzl", "go_grpc_library")  # noqa
load("@io_bazel_rules_scala//scala_proto:scala_proto.bzl", "scalapb_proto_library")  # noqa

proto_library(  # noqa
    name="calculator_proto",
    srcs=["calculator.proto"],
)

go_grpc_library(  # noqa
    name="calculator_go_proto",
    proto=":calculator_proto",
    importpath="github.com/dr4ke616/protogen/calculator",
    visibility=["//visibility:public"]
)

scalapb_proto_library(  # noqa
    name="calculator_scala_proto",
    deps=[":calculator_proto"],
    with_grpc=True,
    with_java=False,
)
