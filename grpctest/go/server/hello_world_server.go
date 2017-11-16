package server

import (
	"fmt"
	"log"
	"net"

	pb "github.com/dr4ke616/grpc-test/proto"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

type Server struct{}

func (s *Server) SayHello(ctx context.Context, in *pb.HelloRequest) (*pb.HelloReply, error) {
	log.Printf("Handling incoming request on SayHello")
	return &pb.HelloReply{Message: "Hello " + in.Name}, nil
}

func Start(port int) {
	log.Printf("Starting Go server on %d", port)

	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", port))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}

	s := grpc.NewServer()
	pb.RegisterGreeterServer(s, &Server{})
	s.Serve(lis)
}
