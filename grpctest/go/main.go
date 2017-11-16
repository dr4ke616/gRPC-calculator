package main

import (
	"github.com/dr4ke616/grpc-test/client"
	"github.com/dr4ke616/grpc-test/server"
)

func main() {

	go server.Start(8021)

	client.Call("localhost:8021", "adam")
}
