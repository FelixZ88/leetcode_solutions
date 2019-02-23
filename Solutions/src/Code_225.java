import jdk.internal.util.xml.impl.ReaderUTF8;

public class Code_225 {


    public class MyStack {
        /**
         * Initialize your data structure here.
         */

        private Dequeue head = null, tail = null;

        public MyStack() {
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            Dequeue node = new Dequeue();
            node.val = x;
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = tail.next;
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            Dequeue top = tail;
            if (tail == head) {
                tail = null;
                head = null;
            } else {
                tail = top.prev;
                tail.next = null;
                top.next = null;
            }
            return top.val;
        }

        /**
         * Get the top element.
         */
        public int top() {
            if (tail != null) {
                return tail.val;
            } else {
                throw new RuntimeException("None Element");
            }
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return head == null;
        }

    }


    public static class Dequeue {
        Dequeue prev, next;
        int val;
    }
}