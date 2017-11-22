package(default_visibility=["//visibility:public"])  # noqa

load("@io_bazel_rules_go//go:def.bzl", "go_library", "go_binary")  # noqa

go_library(  # noqa
    name="server",
    srcs=[
        "calculator.go",
        "calculator_server.go",
    ],
    deps=[
        "//calculator/proto:calculator_go_proto",
        "@org_golang_google_grpc//:go_default_library",
        "@org_golang_x_net//context:go_default_library",
    ],
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
