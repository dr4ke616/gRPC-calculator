package main

import (
	"fmt"
	"github.com/dr4ke616/grpc-test/client"
)

func main() {
	s, _ := client.Test()
	fmt.Println("hello world ", s)
}
