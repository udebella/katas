import java.util.Stack;

public class RpnCalculator {

    public static int calculate(String s) {
        String[] expr = s.split(" ");

        Stack<Integer> stack = new Stack<>();
        for (String e: expr) {

            if (OP.isOperator(e)) {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                stack.push(OP.findBySymbol(e).calc(operand1, operand2));
            } else {
                stack.push(Integer.valueOf(e));
            }
        }

        return stack.pop();
    }
}
