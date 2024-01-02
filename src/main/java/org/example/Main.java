package org.example;

import org.example.queue.Queue;
import org.example.stack.Stack;

public class Main {
    public static void main(String[] args) {

        Queue myQueue = new Queue(2);
        myQueue.enqueue(1);

        // (2) Items - Returns 2 Node
        System.out.println(myQueue.dequeue().getValue());
        // (1) Item - Returns 1 Node
        System.out.println(myQueue.dequeue().getValue());
        // (0) Items - Returns null
        System.out.println(myQueue.dequeue());

    }
}