load("@org_pubref_rules_protobuf//go:rules.bzl", "go_proto_library")  # noqa
load("@io_bazel_rules_scala//scala_proto:scala_proto.bzl", "scalapb_proto_library")  # noqa

proto_library(  # noqa
    name="calculator_proto",
    srcs=["calculator.proto"],
)

scalapb_proto_library(  # noqa
    name="calculator_scala_proto",
    deps=[":calculator_proto"],
    with_grpc=True,
    with_java=False,
    visibility=["//visibility:public"],
)

go_proto_library(  # noqa
    name="calculator_go_proto",
    protos=["calculator.proto"],
    with_grpc=True,
    importpath="github.com/dr4ke616/protogen/calculator",
    visibility=["//visibility:public"],
)
