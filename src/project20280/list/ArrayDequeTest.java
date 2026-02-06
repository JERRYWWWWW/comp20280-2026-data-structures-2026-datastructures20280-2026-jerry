package project20280.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {
    @Test
    public void testArrayDeque() {
        ArrayDeque<String> deque = new ArrayDeque<>(5);
        System.out.println("--- Testing ArrayDeque ---");

        deque.addLast("Middle");
        deque.addFirst("Front"); // 在前面插入
        deque.addLast("Back");   // 在后面插入

        // 顺序应该是: Front -> Middle -> Back
        System.out.println("Remove First: " + deque.removeFirst()); // Front
        System.out.println("Remove Last: " + deque.removeLast());   // Back
        System.out.println("Remaining: " + deque.removeFirst());    // Middle
    }
}