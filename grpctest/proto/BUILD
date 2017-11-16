load("@org_pubref_rules_protobuf//go:rules.bzl", "go_proto_library")  # noqa
load("@io_bazel_rules_scala//scala_proto:scala_proto.bzl", "scalapb_proto_library")  # noqa

proto_library(  # noqa
    name="helloworld_proto",
    srcs=["helloworld.proto"],
)

scalapb_proto_library(  # noqa
    name="helloworld_scala_proto",
    deps=[":helloworld_proto"],
    with_grpc=True,
    with_java=False,
    visibility=["//visibility:public"],
)

go_proto_library(  # noqa
    name="helloworld_go_proto",
    protos=["helloworld.proto"],
    with_grpc=True,
    importpath="github.com/dr4ke616/grpc-test/proto",
    visibility=["//visibility:public"],
)
