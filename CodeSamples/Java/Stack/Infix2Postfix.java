import java.util.Scanner;
import java.util.EmptyStackException;

public class Infix2Postfix {

    // Return the precedence of an operator
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            default:
                return 0;
        }
    }

    // Check whether a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-'
                || ch == '*' || ch == '/';
    }

    // Convert infix expression to postfix expression
    public static String infixToPostfix(String infix) {
        Stack<Character> operatorStack = new Stack<Character>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char nextChar = infix.charAt(i);

            // Ignore spaces
            if (Character.isWhitespace(nextChar)) {
                continue;
            }

            // If operand, add it to postfix
            if (Character.isDigit(nextChar)) {
                postfix.append(nextChar);
            }

            // If opening parenthesis, push onto stack
            else if (nextChar == '(') {
                operatorStack.push(nextChar);
            }

            // If closing parenthesis, pop until '('
            else if (nextChar == ')') {
                while (!operatorStack.isEmpty()
                        && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }

                if (operatorStack.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Mismatched parentheses.");
                }

                operatorStack.pop(); // Remove '('
            }

            // If operator, pop operators of higher
            // or equal precedence before pushing it
            else if (isOperator(nextChar)) {
                while (!operatorStack.isEmpty()
                        && operatorStack.peek() != '('
                        && precedence(operatorStack.peek())
                        >= precedence(nextChar)) {
                    postfix.append(operatorStack.pop());
                }

                operatorStack.push(nextChar);
            }

            else {
                throw new IllegalArgumentException(
                        "Invalid character: " + nextChar);
            }
        }

        // Pop remaining operators
        while (!operatorStack.isEmpty()) {
            char operator = operatorStack.pop();

            if (operator == '(') {
                throw new IllegalArgumentException(
                        "Mismatched parentheses.");
            }

            postfix.append(operator);
        }

        return postfix.toString();
    }

    // Evaluate a postfix expression
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> valueStack = new Stack<Integer>();

        for (int i = 0; i < postfix.length(); i++) {
            char nextChar = postfix.charAt(i);

            // If operand, push its integer value
            if (Character.isDigit(nextChar)) {
                valueStack.push(
                        Character.getNumericValue(nextChar));
            }

            // If operator, pop two operands and calculate
            else if (isOperator(nextChar)) {
                if (valueStack.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Invalid postfix expression.");
                }

                int rightOperand = valueStack.pop();

                if (valueStack.isEmpty()) {
                    throw new IllegalArgumentException(
                            "Invalid postfix expression.");
                }

                int leftOperand = valueStack.pop();
                int result;

                switch (nextChar) {
                    case '+':
                        result = leftOperand + rightOperand;
                        break;

                    case '-':
                        result = leftOperand - rightOperand;
                        break;

                    case '*':
                        result = leftOperand * rightOperand;
                        break;

                    case '/':
                        if (rightOperand == 0) {
                            throw new ArithmeticException(
                                    "Division by zero.");
                        }

                        result = leftOperand / rightOperand;
                        break;

                    default:
                        throw new IllegalArgumentException(
                                "Unknown operator.");
                }

                valueStack.push(result);
            }
        }

        // A valid expression must leave exactly one result
        if (valueStack.isEmpty()) {
            throw new IllegalArgumentException(
                    "Empty or invalid expression.");
        }

        int answer = valueStack.pop();

        if (!valueStack.isEmpty()) {
            throw new IllegalArgumentException(
                    "Invalid expression: too many operands.");
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter an infix expression: ");
            String infix = input.nextLine();

            String postfix = infixToPostfix(infix);

            System.out.println("Postfix expression: " + postfix);

            int result = evaluatePostfix(postfix);

            System.out.println("Result: " + result);
        }
        catch (EmptyStackException e) {
            System.out.println("Error: Invalid expression.");
        }
        catch (IllegalArgumentException
               | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            input.close();
        }
    }
}

