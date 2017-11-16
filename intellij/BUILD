load("@bazel_tools//tools/build_defs/pkg:pkg.bzl", "pkg_tar")  # noqa

pkg_tar(  # noqa
    name="intellij",
    srcs=[
        "//grpctest/scala/server",
        "//grpctest/scala/client",
        "//grpctest/proto:calculator_scala_proto",
        "@protobuf_java//jar:file",
        "@grpc_core//jar:file",
        "@grpc_netty//jar:file",
        "@grpc_protobuf//jar:file",
        "@grpc_stub//jar:file",
    ]
)
