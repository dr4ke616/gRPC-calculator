load("@io_bazel_rules_go//go:def.bzl", "go_binary")  # noqa

go_binary(  # noqa
    name="helloworld",
    srcs=[
        "main.go"
    ],
    deps=[
        "//grpctest/go/client"
    ],
    importpath="github.com/dr4ke616/grpc-test",
)
