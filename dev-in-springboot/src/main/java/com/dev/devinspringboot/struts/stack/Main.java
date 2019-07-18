package com.dev.devinspringboot.struts.stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            System.out.print(pop + " ");
        }
    }
}
