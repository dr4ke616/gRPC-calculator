
#
# Scala
#
rules_scala_version = "33fed13f7a2e776e2cd73aabc66ce0d5cb3b0f1f"
http_archive(  # noqa
    name="io_bazel_rules_scala",
    url="https://github.com/bazelbuild/rules_scala/archive/{}.zip".format(
        rules_scala_version),
    type="zip",
    strip_prefix="rules_scala-{}".format(rules_scala_version)
)

load("@io_bazel_rules_scala//scala:scala.bzl", "scala_repositories")  # noqa
scala_repositories()  # noqa

load("@io_bazel_rules_scala//scala_proto:scala_proto.bzl", "scala_proto_repositories")  # noqa
scala_proto_repositories()  # noqa

#
# Go
#
http_archive(  # noqa
    name="io_bazel_rules_go",
    url="https://github.com/bazelbuild/rules_go/releases/download/0.7.0/rules_go-0.7.0.tar.gz",  # noqa
    sha256="91fca9cf860a1476abdc185a5f675b641b60d3acf0596679a27b580af60bf19c",
)

load("@io_bazel_rules_go//go:def.bzl", "go_rules_dependencies", "go_register_toolchains")  # noqa
go_rules_dependencies()  # noqa
go_register_toolchains()  # noqa

load("@io_bazel_rules_go//proto:def.bzl", "proto_register_toolchains")  # noqa
proto_register_toolchains()  # noqa
