package main

import (
	"fmt"
	"github.com/dr4ke616/grpc-test/client"
	"github.com/dr4ke616/grpc-test/server"
)

func main() {
	s, _ := client.Test()
	fmt.Println("hello world ", s)

	server.Start(8021)
}
