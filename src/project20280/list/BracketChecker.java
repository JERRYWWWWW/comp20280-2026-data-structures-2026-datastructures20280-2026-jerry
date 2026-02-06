package project20280.list;

import java.util.Stack;
import java.util.Scanner;

public class BracketChecker {

    public static boolean checkParentheses(String in) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);

            // 1. 遇到左括号，入栈 [cite: 58]
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 2. 遇到右括号 [cite: 59]
            else if (c == ')' || c == '}' || c == ']') {
                // 3. 栈为空，说明缺少左括号 [cite: 61]
                if (stack.isEmpty()) return false;

                char open = stack.pop();

                // 4. 检查是否匹配 [cite: 60]
                if (!isMatchingPair(open, c)) {
                    return false;
                }
            }
        }

        // 5. 循环结束栈非空，说明缺少右括号 [cite: 62]
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    // 测试主函数，参考题目提供的框架 [cite: 94-124]
    public static void main(String[] args) {
        String[] inputs = {
                "{[()]}",           // Correct
                "a{b[c]d}e",        // Correct
                "a{b(c]d}e",        // Incorrect
                "((((",             // Incorrect
                "]"                 // Incorrect
        };

        for (String input : inputs) {
            boolean isBalanced = checkParentheses(input);
            System.out.println("Input: " + input + " -> Balanced? " + (isBalanced ? "Yes" : "No"));
        }
    }
}