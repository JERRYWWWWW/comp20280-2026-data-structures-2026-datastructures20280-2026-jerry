package project20280.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    @Test
    public void testLinkedQueue() {
        // 1. 实例化：指定泛型为 String
        LinkedQueue<String> queue = new LinkedQueue<>();
        System.out.println("--- Testing LinkedQueue ---");

        // 2. 检查初始状态
        System.out.println("Is empty? (Should be true): " + queue.isEmpty());

        // 3. 入队操作 (Enqueue)
        System.out.println("Enqueuing: Alice, Bob, Charlie");
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");

        // 4. 查看队头 (First) - 应该是最早进去的 Alice
        System.out.println("First person (Should be Alice): " + queue.first());

        // 5. 出队操作 (Dequeue)
        System.out.println("Dequeued: " + queue.dequeue()); // 移除 Alice
        System.out.println("Next person (Should be Bob): " + queue.first());

        // 6. 验证大小变化
        System.out.println("Current size (Should be 2): " + queue.size());

        // 7. 全部清空验证
        queue.dequeue(); // 移除 Bob
        queue.dequeue(); // 移除 Charlie
        System.out.println("Is empty after clearing? " + queue.isEmpty()); // true
    }
}