package project20280.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    @Test
    public void testArrayQueue() {
        // 创建一个容量只有 3 的队列来测试循环逻辑
        ArrayQueue<Integer> queue = new ArrayQueue<>(3);
        System.out.println("--- Testing ArrayQueue (Circular) ---");

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3); // 此时数组已满

        System.out.println("Dequeued: " + queue.dequeue()); // 移除 1，空出一个位置

        // 关键点：虽然数组索引已经到底，但因为是循环队列，这里不应该报错
        queue.enqueue(4);
        System.out.println("Next to dequeue (Should be 2): " + queue.first());
        System.out.println("Current Size: " + queue.size()); // 3
    }
}