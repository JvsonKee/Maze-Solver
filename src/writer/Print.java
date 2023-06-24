package writer;
import java.util.Scanner;

import datastructures.DoubleLinkedQueue;

/**
 * Menu class
 */
public class Print {
    Scanner scanner = new Scanner(System.in);

    public void printSearchHeader(int x) {
        switch(x) {
            case 1: 
                System.out.println("-------------Depth-First Search-------------\n");
                break;
            case 2:
                System.out.println("-------------Breadth-First Search-------------\n");
                break;
        }
    }

    public void printTrailQueue(int x) {
        switch(x) {
            case 1: 
                System.out.println("Depth-First Search Trail Queue");
                break;
            case 2:
                System.out.println("Breadth-First Search Trail Queue");
                break;
        }
    }

    public void printStepsToComplete(DoubleLinkedQueue<String> queue) {
        System.out.println("\n" + queue.size() + " steps were taken to complete the maze.");
    }

    public int searchMethod() {
        System.out.println();
        System.out.println("(1) Depth-First Search");
        System.out.println("(2) Breadth-First Search");
        System.out.println();
        System.out.print("Enter seach method: ");
        int input = scanner.nextInt();
        return input;
    }

    public String mazeNameInput() {
        System.out.print("Enter the name of the maze file: ");
        String input = scanner.nextLine();
        return input;
    }
}
