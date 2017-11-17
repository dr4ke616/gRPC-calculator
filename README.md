# Experimental gRPC Services

Creating simple client server application using gRPC.

Some available resources:
- [Building gRPC services with `bazel` and `rules_protobuf`](https://grpc.io/blog/bazel_rules_protobuf)
- [gRPC Java Repo](https://github.com/grpc/grpc-java)
- [gRPC Scala Guide](https://scalapb.github.io/grpc.html)
- [Sample Scala App](https://github.com/xuwei-k/grpc-scala-sample)


## Running Locally

Using `bazel` to build:

```bash
bazel build "..."
```

Using `bazel` to run:

```bash
bazel run //calculator/scala/helloworld
```
