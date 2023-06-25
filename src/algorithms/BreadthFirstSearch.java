package algorithms;
import mazes.Cell;
import mazes.Maze;
import datastructures.DoubleLinkedQueue;

/**
 * Breadth-first search class
 */
public class BreadthFirstSearch {

    /**
     * Breadth-first search algorithm
     * 
     * @param maze - Input maze
     * @param queue - The queue
     * @return - A trail queue of the steps taken throughout the maze
     */
    public DoubleLinkedQueue<String> search(Maze maze, DoubleLinkedQueue<Cell> queue) {

        DoubleLinkedQueue<String> trailQueue = new DoubleLinkedQueue<>();
        boolean moreToSearch = true;
        int[] start = maze.getStart();
        Cell s = maze.getCell(start[0], start[1]);
        queue.enqueue(s);
        while (!queue.isEmpty() && moreToSearch) {
            Cell j = queue.dequeue();
            j.setVisited(true);
            trailQueue.enqueue(j.toString());
            if (j.getAppearance() == 'c') {
                moreToSearch = false;
            } else {
                Cell k;
                for (int i = 0; i < 4; i++) {
                    k = j.peek(i, maze);
                    if (k.getAppearance() == 'c') {
                        queue.enqueue(k);
                    } else if (k.getAppearance() != '1' && !k.isVisited()) {
                        queue.enqueue(k);
                        k.setDirection(k, i);
                    }
                    maze.printMaze();
                }
            }
        }
        return trailQueue;
    }

}
