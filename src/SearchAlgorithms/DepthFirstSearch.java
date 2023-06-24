package searchalgorithms;
import datastructures.DoubleLinkedQueue;
import datastructures.DoubleLinkedStack;
import maze.Cell;
import maze.Maze;

/**
 * Depth-first Search class
 */
public class DepthFirstSearch {

    /**
     * Depth-first search search algorithm
     * 
     * @param maze - Input maze
     * @param stack - The stack
     * @return - A trail queue of the steps taken throughout the maze
     */
    public DoubleLinkedQueue<String> search(Maze maze, DoubleLinkedStack<Cell> stack) {

        DoubleLinkedQueue<String> trailQueue = new DoubleLinkedQueue<>();
        boolean moreToSearch = true;
        int[] start = maze.getStart();
        Cell s = maze.getCell(start[0], start[1]);
        stack.push(s);

        while (!stack.isEmpty() && moreToSearch) {
            Cell j = stack.pop();
            j.setVisited(true);
            trailQueue.enqueue(j.toString());
            if (j.getAppearance() == 'c') {
                moreToSearch = false;
            } else {
                Cell k;
                for (int i = 0; i < 4; i++) {
                    k = j.peek(i, maze);
                    if (k.getAppearance() == 'c') {
                        stack.push(k);
                    } else if (k.getAppearance() != '1' && !k.isVisited()) {
                        stack.push(k);
                        k.setDirection(k, i);
                    }
                    maze.printMaze();
                }
            }
        }
        return trailQueue;
    }   

}

