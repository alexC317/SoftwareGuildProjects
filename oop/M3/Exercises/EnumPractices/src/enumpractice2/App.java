/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enumpractice2;

/**
 *
 * @author Alex
 */
public class App {

    public static void main(String[] args) {
        System.out.println(calculate(MathOperator.PLUS, 2, 2));
        System.out.println(calculate(MathOperator.MINUS, 2, 2));
        System.out.println(calculate(MathOperator.MULTIPLY, 2, 2));
        System.out.println(calculate(MathOperator.DIVIDE, 2, 2));
        

    }

    public enum MathOperator {
        PLUS, MINUS, MULTIPLY, DIVIDE
    }

    public static int calculate(MathOperator operator, int operand1, int operand2) {
        switch (operator) {
            case PLUS:
                return operand1 + operand2;
            case MINUS:
                return operand1 - operand2;
            case MULTIPLY:
                return operand1 * operand2;
            case DIVIDE:
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException();
        }
    }

}
