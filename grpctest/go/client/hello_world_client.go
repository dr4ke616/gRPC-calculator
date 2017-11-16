package client

import (
	"log"

	pb "github.com/dr4ke616/grpc-test/proto"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

func Call(address string, nameIn string) {

	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Connection failure: %v", err)
	}
	defer conn.Close()

	c := pb.NewGreeterClient(conn)
	r, err := c.SayHello(context.Background(), &pb.HelloRequest{Name: nameIn})
	if err != nil {
		log.Fatalf("could not greet: %v", err)
	}
	log.Printf("Greeting: %s", r.Message)

}
