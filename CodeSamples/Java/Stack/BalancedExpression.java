
import java.util.Scanner;
import java.util.Stack;

public class BalancedExpression {

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        boolean isBalanced = true;

        int i = 0;

        while (isBalanced && i < expression.length()) {
            char nextChar = expression.charAt(i);

            switch (nextChar) {
                case '(':
                case '[':
                case '{':
                    stack.push(nextChar);
                    break;

                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        isBalanced = false;
                    } else {
                        char openDelimiter = stack.pop();

                        if ((openDelimiter == '(' && nextChar != ')') ||
                                (openDelimiter == '[' && nextChar != ']') ||
                                (openDelimiter == '{' && nextChar != '}')) {
                            isBalanced = false;
                        }
                    }
                    break;

                default:
                    // Ignore characters that are not delimiters
                    break;
            }

            i++;
        }

        if (!stack.isEmpty()) {
            isBalanced = false;
        }

        return isBalanced;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an expression (No spaces) >");
        String inputString = input.nextLine();

        System.out.println(inputString + " balanced?.... "
                + isBalanced(inputString));
        input.close();
    }
}
