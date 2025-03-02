package edu.ktu.ds.lab2.utils;

import java.util.Scanner;

public class FirstTask {

    private BstSet<Integer> bstSet = new BstSet<>();
    private int k = 0;
    private int result = 0;

    public static void main(String[] args) {

        FirstTask task = new FirstTask();
        task.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a k: ");
        String text = scanner.nextLine();
        if (text.isEmpty()) {
            k = 0;
        } else {
            k = Integer.parseInt(text);
        }

        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("")) {
                System.out.print("Generated tree:\n\n");
                break;
            }

            bstSet.add(Integer.parseInt(input));
        }

        scanner.close();

        if (bstSet.isEmpty()) {
            generateFirst();
//            generateSecond();
        }

        String visualizedString = bstSet.toVisualizedString(",");
        System.out.println(visualizedString);

        calculateBiggestUnbalancedHeight(bstSet.root);
        if (result > k){
            System.out.println("Rezultatas: nesubalancuotas (" + false + ")");
        } else {
            System.out.println("Rezultatas: subalancuotas (" + true + ")");
        }
    }

    private void generateFirst() {
        k = 2;
        bstSet.add(15);
        bstSet.add(7);
        bstSet.add(23);
        bstSet.add(4);
        bstSet.add(9);
        bstSet.add(1);
    }

    private void generateSecond() {
        k = 2;
        bstSet.add(15);
        bstSet.add(5);
        bstSet.add(23);
        bstSet.add(4);
        bstSet.add(11);
        bstSet.add(6);
        bstSet.add(8);
        bstSet.add(9);
        bstSet.add(18);
        bstSet.add(17);
        bstSet.add(20);
        bstSet.add(19);
        bstSet.add(50);
        bstSet.add(40);
        bstSet.add(33);
        bstSet.add(74);
        bstSet.add(69);
        bstSet.add(79);
    }

    private Integer calculateBiggestUnbalancedHeight(BstSet.BstNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        int leftH = calculateBiggestUnbalancedHeight(node.left);
        int rightH = calculateBiggestUnbalancedHeight(node.right);

        int unbalanced = Math.abs(leftH - rightH);

        if (unbalanced > 1 && unbalanced > result) {
            result = unbalanced;
        }

        return Math.max(leftH, rightH) + 1;
    }
}
