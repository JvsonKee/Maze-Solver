package mazes;

/**
 * Cell class
 */
public class Cell {
    private boolean visited;
    private char appearance;
    private int row;
    private int column;

    public Cell(char appearance, int row, int column) {
        this.row = row;
        this.column = column;
        this.visited = false;
        this.appearance = appearance;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean x) {
        this.visited = x;
    }

    public char getAppearance() {
        return appearance;
    }

    public void setAppearance(char appearance) {
        this.appearance = appearance;
    }

    public void setDirection(Cell cell, int direction) {
        if (direction == 0) {
            cell.setAppearance('^');
        }
        if (direction == 1) {
            cell.setAppearance('v');
        }
        if (direction == 2) {
            cell.setAppearance('<');
        }
        if (direction == 3) {
            cell.setAppearance('>');
        }
    }

    public Cell peek(int direction, Maze maze) {
        switch(direction) {
            case 0:
                if (row - 1 < 0) {
                    return maze.getCell(row, column);
                }
                return maze.getCell(row - 1, column);
            case 1:
                if (row + 1 >= maze.rows) {
                    return maze.getCell(row, column);
                }
                return maze.getCell(row + 1, column);
            case 2:
                if (column - 1 < 0) {
                    return maze.getCell(row, column);
                }
                return maze.getCell(row, column - 1);
            case 3:
                if (column + 1 >= maze.columns) {
                    return maze.getCell(row, column);
                }
                return maze.getCell(row, column + 1);
        }
        return null;
    }

    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}
