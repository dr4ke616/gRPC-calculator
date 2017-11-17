package client

import (
	"log"

	pb "github.com/dr4ke616/protogen/calculator"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

func Calculate(address string, expression string) string {

	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Connection failure: %v", err)
	}
	defer conn.Close()

	c := pb.NewCalculatorClient(conn)
	r, err := c.Evaluate(context.Background(), &pb.ExpressionRequest{Expr: expression})
	if err != nil {
		log.Fatalf("could not greet: %v", err)
	}
	return r.Answer

}
