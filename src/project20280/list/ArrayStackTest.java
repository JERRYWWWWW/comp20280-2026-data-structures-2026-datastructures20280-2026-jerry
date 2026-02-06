package project20280.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    public void testStackOperations() {
        ArrayStack<Integer> stack = new ArrayStack<>();

        assertTrue(stack.isEmpty()); // 断言栈一开始是空的

        stack.push(5);
        stack.push(10);

        assertEquals(2, stack.size()); // 断言大小是 2
        assertEquals(Integer.valueOf(10), stack.pop()); // 断言弹出的必须是 10
        assertEquals(Integer.valueOf(5), stack.top());  // 断言现在的栈顶是 5
    }
}