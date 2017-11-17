# Experimental gRPC Services

Creating simple client server application using gRPC.

Some available resources:
- [Building gRPC services with `bazel` and `rules_protobuf`](https://grpc.io/blog/bazel_rules_protobuf)
- [gRPC Java Repo](https://github.com/grpc/grpc-java)
- [gRPC Scala Guide](https://scalapb.github.io/grpc.html)
- [Sample Scala App](https://github.com/xuwei-k/grpc-scala-sample)


## Building and Running

Using `bazel` to build the whole project:

```bash
bazel build "..."
```

List the project contents

```bash
bazel query "..." --output label_kind | sort | column -t
```

Using `bazel` to run the server:

```bash
# Go Server
bazel run //calculator/go/server:run_server

# Scala Server
bazel run //calculator/scala/server:run_server
```

Using `bazel` to run the client:

```bash
# Go Client
bazel run //calculator/go/client:run_client

# Scala Client
bazel run //calculator/scala/client:run_client
```

If using Intellij, read [here](intellij/README.md)
