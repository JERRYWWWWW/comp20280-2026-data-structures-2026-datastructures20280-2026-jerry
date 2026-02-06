package project20280.list;

import java.util.Stack;

public class BaseConverter {

    // 字符表，用于处理大于10的进制（如16进制需要A-F）
    private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String convertToBase(long num, int base) {
        if (num == 0) return "0";

        Stack<Character> stack = new Stack<>();
        boolean isNegative = num < 0;
        if (isNegative) num = -num;

        while (num > 0) {
            int remainder = (int) (num % base);
            stack.push(DIGITS.charAt(remainder)); // 处理大于9的基数
            num /= base;
        }

        StringBuilder sb = new StringBuilder();
        if (isNegative) sb.append("-");

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // 为了匹配题目中的特定测试函数 convertToBinary
    public static String convertToBinary(long dec_num) {
        return convertToBase(dec_num, 2);
    }
}
