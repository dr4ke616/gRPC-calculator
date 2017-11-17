package(default_visibility=["//visibility:public"])  # noqa

load("@io_bazel_rules_go//go:def.bzl", "go_library", "go_binary")  # noqa
load("@org_pubref_rules_protobuf//go:rules.bzl", "GRPC_COMPILE_DEPS")  # noqa

go_library(  # noqa
    name="server",
    srcs=[
        "calculator.go",
        "calculator_server.go",
    ],
    deps=["//calculator/proto:calculator_go_proto"] + GRPC_COMPILE_DEPS,  # noqa
    importpath="github.com/dr4ke616/calculator/server",
)

go_binary(  # noqa
    name="run_server",
    srcs=[
        "main.go"
    ],
    deps=[
        ":server",
    ],
    importpath="github.com/dr4ke616/calculator/server",
)
