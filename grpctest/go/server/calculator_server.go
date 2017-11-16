package server

import (
	"fmt"
	"log"
	"net"

	pb "github.com/dr4ke616/grpctest/proto/calculator"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

type Server struct{}

func (s *Server) Evaluate(ctx context.Context, in *pb.ExpressionRequest) (*pb.ExpressionAnswer, error) {
	log.Printf("Handling incoming evaluation request")
	ans := EvaluateExpression(in.Expr)
	return &pb.ExpressionAnswer{Answer: fmt.Sprintf("%d", ans)}, nil
}

func Start(port int) {
	log.Printf("Starting Calculator server on %d...", port)

	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", port))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}

	s := grpc.NewServer()
	pb.RegisterCalculatorServer(s, &Server{})
	s.Serve(lis)
}
