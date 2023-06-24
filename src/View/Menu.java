package View;
import java.util.Scanner;

/**
 * Menu class
 */
public class Menu {
    Scanner scanner = new Scanner(System.in);

    public int searchMethod() {
        System.out.println();
        System.out.println("(1) Depth-First Search");
        System.out.println("(2) Breadth-First Search");
        System.out.println();
        System.out.print("Enter seach method: ");
        int input = scanner.nextInt();
        scanner.close();
        return input;
    }

    public String mazeNameInput() {
        System.out.print("Enter the name of the maze file: ");
        String input = scanner.nextLine();
        return input;
    }
}
