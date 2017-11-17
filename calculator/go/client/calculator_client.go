package client

import (
	"log"

	pb "github.com/dr4ke616/protogen/calculator"

	"golang.org/x/net/context"
	"google.golang.org/grpc"
)

func Connect(address string) (*grpc.ClientConn, error) {
	return grpc.Dial(address, grpc.WithInsecure())
}

func Calculate(conn *grpc.ClientConn, expression string) string {

	c := pb.NewCalculatorClient(conn)
	r, err := c.Evaluate(context.Background(), &pb.ExpressionRequest{Expr: expression})
	if err != nil {
		log.Fatalf("could not greet: %v", err)
	}
	return r.Answer

}
