package(default_visibility=["//visibility:public"])  # noqa

load("@io_bazel_rules_go//go:def.bzl", "go_library", "go_binary")  # noqa
load("@org_pubref_rules_protobuf//go:rules.bzl", "GRPC_COMPILE_DEPS")  # noqa

go_library(  # noqa
    name="client",
    srcs=[
        "calculator_client.go",
    ],
    deps=["//calculator/proto:calculator_go_proto"] + GRPC_COMPILE_DEPS,  # noqa
    importpath="github.com/dr4ke616/calculator/client",
)

go_binary(  # noqa
    name="run_client",
    srcs=[
        "main.go"
    ],
    deps=[
        ":client",
    ],
    importpath="github.com/dr4ke616/calculator/client",
)
