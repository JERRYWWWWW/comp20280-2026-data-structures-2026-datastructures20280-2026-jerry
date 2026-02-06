package project20280.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {
    @Test
    public void testLinkedStack() {
        LinkedStack<String> stack = new LinkedStack<>();
        System.out.println("--- Testing LinkedStack ---");

        stack.push("Apple");
        stack.push("Banana");
        stack.push("Cherry");

        System.out.println("Top element (Should be Cherry): " + stack.top()); //
        System.out.println("Popped: " + stack.pop()); // Cherry
        System.out.println("New Top: " + stack.top()); // Banana
        System.out.println("Stack Size: " + stack.size()); // 2
    }
}