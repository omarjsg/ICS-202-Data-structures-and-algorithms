
public class postfixEvaluator {

	public static void main(String[] args) {
		try {
			int postfix = evaluatePostfix("31 2 + 4 *");
			System.out.println("\nResult = " + postfix);
		} catch (IllegalArgumentException ex) {
			System.err.println(ex);
		}
	}

	private static int evaluatePostfix(String postfix) {
		System.out.println("Evaluating the expression: \"" + postfix + "\".");
		Stack stack = new Stack();
		String operand = "";
		int result = 0;
		int operandsCounter = 0;
		for (int index = 0; index < postfix.length(); index++) {
			if (postfix.charAt(index) == ' ') {
				continue;
			} else if (Character.isDigit(postfix.charAt(index))) {
				while (!Character.isWhitespace(postfix.charAt(index))) {
					operand += postfix.charAt(index);
					index++;
				}
				if (operandsCounter == 0) {
					System.out.printf("%nFirst input \"%s\".%n", operand);
					System.out.printf("Storing \"%s\" in the stack%n", operand);
					stack.push(Integer.parseInt(operand));
					operand = "";
					operandsCounter++;
				} else {
					System.out.printf("%nNext input \"%s\".%n", operand);
					System.out.printf("Storing \"%s\" in the stack%n", operand);
					stack.push(Integer.parseInt(operand));
					operand = "";
					operandsCounter++;
				}
			} else {
				if (operandsCounter >= 2) {
					char operator = postfix.charAt(index);
					System.out.printf("%nNext input \"%s\": %n", operator);
					int val1 = (int) stack.pop();
					int val2 = (int) stack.pop();
					System.out.println("1- Popping \"" + val2 + "\" and \"" + val1 + "\" from the stack.");
					switch (operator) {
						case '+':
							System.out.println(
									"2- Adding " + val2 + " with " + val1 + ". => ( " + val2 + " + " + val1 + " )");
							result = val2 + val1;
							stack.push(result);
							System.out.printf("3- Storing \"%s\" in the stack%n", result);
							break;

						case '-':
							System.out.println("2- Subtracting " + val1 + " from " + val2 + ". => ( " + val2 + " - "
									+ val1 + " )");
							result = val2 - val1;
							stack.push(result);
							System.out.printf("3- Storing \"%s\" in the stack%n", result);
							break;

						case '/':
							System.out.println(
									"2- Dividing " + val2 + " by " + val1 + ". => ( " + val2 + " / " + val1 + " )");
							result = val2 / val1;
							stack.push(result);
							System.out.printf("3- Storing \"%s\" in the stack%n", result);
							break;

						case '*':
							System.out.println(
									"1- Multiplying " + val2 + " by " + val1 + ". => ( " + val2 + " * " + val1 + " )");
							result = val2 * val1;
							stack.push(result);
							System.out.printf("3- Storing \"%s\" in the stack%n", result);
							break;
						default:
							throw new IllegalArgumentException("Error: invalid input \" " + operator + " \".");
					}
				} else {
					throw new IllegalArgumentException("Error: cannot start with one operand only");
				}
			}
		}
		result = (int) stack.pop();
		System.out.println("\nFinally, popping \"" + result + "\" from the stack.");
		return result;
	}
}
