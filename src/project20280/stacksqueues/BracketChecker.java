package project20280.stacksqueues;

import project20280.interfaces.Stack;

class BracketChecker {
    private final String input;

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        Stack<Character> stack = new LinkedStack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {

                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;


                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();

                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at index " + i + " doesn't match " + chx);
                            return;
                        }
                    } else {

                        System.out.println("Error: " + ch + " at index " + i + " has no matching opening bracket");
                        return;
                    }
                    break;
                default:

                    break;
            }
        }


        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter for " + stack.pop());
        } else {
            System.out.println("This string is correct");
        }
    }

    public static void main(String[] args) {
        String[] inputs = {
                "[]]()()", // not correct
                "c[d]", // correct\n" +
                "a{b[c]d}e", // correct\n" +
                "a{b(c]d}e", // not correct; ] doesn't match (\n" +
                "a[b{c}d]e}", // not correct; nothing matches final }\n" +
                "a{b(c) ", // // not correct; Nothing matches opening {
        };

        for (String input : inputs) {
            BracketChecker checker = new BracketChecker(input);
            System.out.println("checking: " + input);
            checker.check();
        }
    }
}