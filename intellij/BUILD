load("@bazel_tools//tools/build_defs/pkg:pkg.bzl", "pkg_tar")  # noqa

pkg_tar(  # noqa
    name="intellij",
    srcs=[
        "//calculator/scala/server",
        "//calculator/scala/client",
        "//calculator/proto:calculator_scala_proto",
        "@scalac_rules_protobuf_java//jar",
        "@scala_proto_rules_scalapb_runtime_grpc//jar",
    ]
)
