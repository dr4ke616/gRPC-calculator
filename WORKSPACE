
#
# Scala
#
rules_scala_version = "6f398b13a962b47d4497aa96a892c3c15933036e"
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

# Pulling specific commit due to bug
# fixed here - https://github.com/pubref/rules_protobuf/pull/159
git_repository(  # noqa
    name="org_pubref_rules_protobuf",
    remote="https://github.com/pubref/rules_protobuf",
    commit="b265556dc21f42e0db7187cd2b752ca6a1b5d852",
)
load("@org_pubref_rules_protobuf//go:rules.bzl", "go_proto_repositories")  # noqa
go_proto_repositories()  # noqa

load("@io_bazel_rules_go//proto:def.bzl", "proto_register_toolchains")  # noqa
proto_register_toolchains()  # noqa

load("@org_pubref_rules_protobuf//grpc_gateway:rules.bzl", "grpc_gateway_proto_repositories")  # noqa
grpc_gateway_proto_repositories()  # noqa
