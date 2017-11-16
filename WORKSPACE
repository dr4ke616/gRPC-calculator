#
# Proto
#
new_local_repository(  # noqa
    name="com_google_protobuf",
    path="third_party/protobuf",
    build_file="third_party/protobuf/com_google_protobuf.BUILD",
)

new_local_repository(  # noqa
    name="com_google_protobuf_java",
    path="third_party/protobuf",
    build_file="third_party/protobuf/com_google_protobuf_java.BUILD",
)

maven_jar(name="protoc_jar", artifact="com.github.os72:protoc-jar:3.2.0")  # noqa
maven_jar(name="protobuf_java", artifact="com.google.protobuf:protobuf-java:3.2.0")  # noqa

#
# Scala
#
rules_scala_version = "85308acbd316477f3072e033e7744debcba4f054"
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


#
# GRPC
#
maven_jar(name="grpc_core", artifact="io.grpc:grpc-core:1.7.0")   # noqa
maven_jar(name="grpc_netty", artifact="io.grpc:grpc-netty:1.7.0")   # noqa
maven_jar(name="grpc_protobuf", artifact="io.grpc:grpc-protobuf:1.7.0")   # noqa
maven_jar(name="grpc_stub", artifact="io.grpc:grpc-stub:1.7.0")   # noqa
