package main

import (
	"log"

	"github.com/dr4ke616/grpc-test/client"
)

func main() {
	answer := client.Calculate("localhost:1212", "34 + 2")
	log.Printf("Answer: %s", answer)
}
