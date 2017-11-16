package(default_visibility=["//visibility:public"])  # noqa

load("@io_bazel_rules_go//go:def.bzl", "go_library")  # noqa
load("@org_pubref_rules_protobuf//go:rules.bzl", "GRPC_COMPILE_DEPS")  # noqa

go_library(  # noqa
    name="client",
    srcs=[
        "hello_world_client.go",
    ],
    deps=["//grpctest/proto:helloworld_go_proto"] + GRPC_COMPILE_DEPS,  # noqa
    importpath="github.com/dr4ke616/grpc-test/client",
)
