package server

import (
	"go/ast"
	"go/parser"
	"go/token"

	"log"
	"strconv"
)

func eval(exp ast.Expr) int {
	switch exp := exp.(type) {
	case *ast.BinaryExpr:
		return evalBinaryExpr(exp)
	case *ast.BasicLit:
		switch exp.Kind {
		case token.INT:
			i, _ := strconv.Atoi(exp.Value)
			return i
		}
	}

	return 0
}

func evalBinaryExpr(exp *ast.BinaryExpr) int {
	left := eval(exp.X)
	right := eval(exp.Y)

	switch exp.Op {
	case token.ADD:
		return left + right
	case token.SUB:
		return left - right
	case token.MUL:
		return left * right
	case token.QUO:
		return left / right
	}

	return 0
}

func EvaluateExpression(rawExpression string) int {

	exp, err := parser.ParseExpr(rawExpression)
	if err != nil {
		log.Fatalf("Failed to parse expression: %s", err)
	}

	return eval(exp)
}
