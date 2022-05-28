
public class BalancedParentheses {

	public static void main(String[] args) {
		String expr1 = new String("[3 + (2 – 4) + {(a – b)}]");
		String expr2 = new String("[3 + 2( and { 7 + [ a – b} ]");
		printBalancity(expr1);
		printBalancity(expr2);
	}

	public static boolean isBalancedParentheses(String expression) {
		Stack stack = new Stack();
		for (int index = 0; index < expression.length(); index++) {
			char el = expression.charAt(index);
			if (el == '(' || el == '[' || el == '{') {
				stack.push(el);
				continue;
			}
			if (stack.isEmpty()) {
				return false;
			}
			char lastBraket;
			if (el == ')') {
				lastBraket = (char) stack.pop();
				if (lastBraket == '{' || lastBraket == '[')
					return false;
			} else if (el == '}') {
				lastBraket = (char) stack.pop();
				if (lastBraket == '(' || lastBraket == '[')
					return false;
			} else if (el == ']') {
				lastBraket = (char) stack.pop();
				if (lastBraket == '{' || lastBraket == '(')
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void printBalancity(String expression) {
		if (isBalancedParentheses(expression))
			System.out.printf("The expression %s is balanced%n", expression);
		else {
			System.out.printf("The expression %s is not balanced%n", expression);
		}
	}
}
