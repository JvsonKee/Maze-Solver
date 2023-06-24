import DataStructures.DoubleLinkedQueue;
import DataStructures.DoubleLinkedStack;
import FileInitializer.FileInitialization;
import Maze.Cell;
import Maze.Maze;
import SearchAlgorithms.BreadthFirstSearch;
import SearchAlgorithms.DepthFirstSearch;
import View.Menu;

public class App {
    public static void main(String[] args) throws Exception {

        DepthFirstSearch DFS = new DepthFirstSearch();
        BreadthFirstSearch BFS = new BreadthFirstSearch();

        FileInitialization initializer = new FileInitialization();
        Maze maze = initializer.read();

        Menu menu = new Menu();
        int input = menu.searchMethod();

        switch(input) {
            case 1: 
                DoubleLinkedQueue<String> DFSTrailQueue = DFS.search(maze, new DoubleLinkedStack<Cell>());
                System.out.println("Depth-First Search Trail Queue");
                DFSTrailQueue.printQueue();
                break;
            case 2:
                DoubleLinkedQueue<String> BFSTrailQueue = BFS.search(maze, new DoubleLinkedQueue<Cell>());
                System.out.println("Breadth-First Search Trail Queue");
                BFSTrailQueue.printQueue();
                break;
        }
    }
}
