package main

import (
	// "github.com/dr4ke616/grpc-test/client"
	"github.com/dr4ke616/grpctest/server"
)

func main() {
	// fs := token.NewFileSet()
	// ast.Print(fs, tr)

	server.Start(1212)

	// client.Call("localhost:8021", "adam")
}
