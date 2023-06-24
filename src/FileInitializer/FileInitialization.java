package FileInitializer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Maze.Maze;
import View.Menu;

public class FileInitialization {
    public int rows;
    public int columns;

    /**
     * Reads the text file and creates the maze
     * @return - The maze
     */
    public Maze read() {
        Maze maze = null;
        String line = null;
        int r, c;
        BufferedReader br = null;
        FileReader fr = null;
        FileContainer container;
        
        try {
            container = checkFile(br, fr);
            maze = new Maze(rows, columns);
            br = container.getBufferedReader();
            fr = container.getFileReader();
            line = br.readLine();

            if (line == null) {
                System.out.println("Empty file, nothing to read.");
            } else {
                r = 0; 
                while (line != null) {
                    c = 0;
                    while (c < columns) {
                        char character = line.charAt(c);
                        maze.addCell(r, c, character);
                        if (character == 'm') {
                            maze.setStart(r, c);
                        }
                        c++;
                    }
                    line = br.readLine();
                    if (line != null) {
                        r++;
                    }
                }
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("General file input problem " + "reading starting positions");
        }
        return maze;
    }

    /**
     * Checks for a valid file.
     * 
     * @param br - BufferedReader
     * @param fr - FileReader
     * @return - The file container
     */
    private FileContainer checkFile(BufferedReader br, FileReader fr) {
        FileContainer container = null;
        String fileName = null;
        boolean fileFound = false;
        Menu menu = new Menu();
        
        while (fileFound == false) {
            try {
                fileName = menu.mazeNameInput();
                getRows(fileName);
                getColumns(fileName);
                fr = new FileReader(fileName);
                br = new BufferedReader(fr);
                fileFound = true;
            } catch (FileNotFoundException ex) {
                fileNotFound();
            }
        }
        container = new FileContainer(br, fr);
        return container;
    }

    /**
     * Prints out an error if a file is not found
     */
    private void fileNotFound() {
        String location = System.getProperty("user.dir");
        System.out.println("Input file not found in " + location);
    }

    /**
     * Gets the number of rows from the file
     * @param fileName - The name of the input file
     */
    private void getRows(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while(br.readLine() != null) {
                rows++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            fileNotFound();
        } catch (IOException e) {
            System.out.println("this");
        }
    }

    /**
     * Gets the number of columns from the file
     * @param fileName - The name of the input file
     */
    private void getColumns(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();
            columns = line.length();
            br.close();
        } catch (FileNotFoundException e) {
            fileNotFound();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
