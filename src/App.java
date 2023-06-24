import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

import datastructures.DoubleLinkedQueue;
import datastructures.DoubleLinkedStack;
import fileinitializer.FileInitialization;
import maze.Cell;
import maze.Maze;
import searchalgorithms.BreadthFirstSearch;
import searchalgorithms.DepthFirstSearch;
import writer.Print;

public class App {
    public static void main(String[] args) throws Exception {

        DepthFirstSearch DFS = new DepthFirstSearch();
        BreadthFirstSearch BFS = new BreadthFirstSearch();

        FileInitialization initializer = new FileInitialization();
        Maze maze = initializer.read();

        Print printer = new Print();
        int input = printer.searchMethod();

        switch(input) {
            case 1: 
                PrintStream out = new PrintStream(new FileOutputStream("DFSResults.txt"));
                System.setOut(out);

                printer.printSearchHeader(1);
                DoubleLinkedQueue<String> DFSTrailQueue = DFS.search(maze, new DoubleLinkedStack<Cell>());
                printer.printTrailQueue(1);
                DFSTrailQueue.printQueue();
                printer.printStepsToComplete(DFSTrailQueue);
                break;

            case 2:
                PrintStream outBFS = new PrintStream(new FileOutputStream("BFSResults.txt"));
                System.setOut(outBFS);

                printer.printSearchHeader(2);
                DoubleLinkedQueue<String> BFSTrailQueue = BFS.search(maze, new DoubleLinkedQueue<Cell>());
                printer.printTrailQueue(2);
                BFSTrailQueue.printQueue();
                printer.printStepsToComplete(BFSTrailQueue);
                break;

        }
    }
}
