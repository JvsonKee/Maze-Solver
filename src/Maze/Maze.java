package Maze;

/**
 * Maze class
 */
public class Maze {

    Cell[][] maze;

    public int rows;
    public int columns;
    private int[] start;

    public Maze(int rows, int columns) {
        maze = new Cell[rows][columns];
        start = new int[2];
        this.rows = rows;
        this.columns = columns;
    }
    
    public Cell getCell(int r, int c) {
        return maze[r][c];
    }

    public void addCell(int r, int c, char appearance) {
        maze[r][c] = new Cell(appearance, r, c);
    }
    
    public int[] getStart() {
        return start;
    }

    public void setStart(int r, int c) {
        start[0] = r;
        start[1] = c;
    }
    
    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(getCell(i, j).getAppearance());
            }
            System.out.println();
        }
        System.out.println();
    }

}

