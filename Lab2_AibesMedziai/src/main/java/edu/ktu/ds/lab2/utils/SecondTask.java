package edu.ktu.ds.lab2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondTask {
    private AvlSet<Double> avlSet = new AvlSet<>();
    private List<Double> result = new ArrayList<>();

    public static void main(String[] args) {
        SecondTask task = new SecondTask();
        task.run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("")) {
                System.out.print("Generated tree:\n\n");
                break;
            }

            avlSet.add(Double.parseDouble(input));
        }

        scanner.close();

        if (avlSet.isEmpty()) {
            generate();
        }

        String visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);

        findCenterNodes();

        System.out.println("Rezultatas:");

        for (double i : result) {
            System.out.println(i + " ");
        }
    }

    private void generate() {
        avlSet.add(15.0);
        avlSet.add(7.0);
        avlSet.add(23.0);
        avlSet.add(4.0);
        avlSet.add(12.0);
        avlSet.add(19.0);
        avlSet.add(26.0);
        avlSet.add(1.0);
        avlSet.add(5.0);
        avlSet.add(9.0);
        avlSet.add(14.0);
        avlSet.add(16.0);
        avlSet.add(21.0);
        avlSet.add(25.0);
        avlSet.add(30.0);
        avlSet.add(31.0);
        avlSet.add(27.0);
        avlSet.add(25.5);
        avlSet.add(24.0);
        avlSet.add(22.0);
        avlSet.add(20.0);
        avlSet.add(18.0);
        avlSet.add(15.5);
        avlSet.add(14.5);
        avlSet.add(13.0);
        avlSet.add(11.0);
        avlSet.add(8.0);
        avlSet.add(6.0);
        avlSet.add(4.5);
        avlSet.add(2.0);
        avlSet.add(0.5);
    }

//    private void findCenterNodes() {
//
//        int height = getTreeHeight(avlSet.root);
//
//        findInternalNodes(avlSet.root, true, true, 0, height, result);
//    }
//
//    private void findInternalNodes(AvlSet.BstNode<Integer> node, boolean isLeftBoundary, boolean isRightBoundary,
//                                   int level, int maxLevel, List<Integer> centerNodes) {
//        if (node == null) {
//            return;
//        }
//
//        if (level == maxLevel) {
//            return;
//        }
//
//        if (!isLeftBoundary && !isRightBoundary && (node.left != null || node.right != null)) {
//            centerNodes.add(node.element);
//        }
//
//        findInternalNodes(node.left, isLeftBoundary, false, level + 1, maxLevel, centerNodes);
//        findInternalNodes(node.right, false, isRightBoundary, level + 1, maxLevel, centerNodes);
//    }
//
//    private int getTreeHeight(AvlSet.BstNode<Integer> node) {
//        if (node == null) {
//            return -1;
//        }
//        return 1 + Math.max(getTreeHeight(node.left), getTreeHeight(node.right));
//    }

    private void findCenterNodes() {

        findInternalNodes(avlSet.root, true, true, result);
    }

    private void findInternalNodes(AvlSet.BstNode<Double> node, boolean isLeftBoundary, boolean isRightBoundary, List<Double> centerNodes) {
        if (node == null) {
            return;
        }

        if (!isLeftBoundary && !isRightBoundary && (node.left != null || node.right != null)) {
            centerNodes.add(node.element);
        }

        findInternalNodes(node.left, isLeftBoundary, false, centerNodes);
        findInternalNodes(node.right, false, isRightBoundary, centerNodes);
    }
}
