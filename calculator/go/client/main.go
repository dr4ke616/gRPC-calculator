package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"

	"github.com/dr4ke616/calculator/client"
)

func main() {
	conn, err := client.Connect("localhost:1212")
	if err != nil {
		log.Fatalf("Connection failure: %v", err)
	}
	defer conn.Close()

	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("→ ")
		input, _ := reader.ReadString('\n')
		// convert CRLF to LF
		input = strings.Replace(input, "\n", "", -1)

		answer := client.Calculate(conn, input)
		fmt.Printf("= %s\n", answer)
	}
}
