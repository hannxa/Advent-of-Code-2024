package decemberSecond;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Puzzle {
    static List<List<Integer>> puzzleList = new ArrayList<>();

    public static void main(String[] args) {
        readFile("puzzle.txt");
        int howMuchSafe = 0;
        for (List<Integer> row : puzzleList) {
            int increasedProperly = 0;
            int decreasedProperly = 0;

            for (int j = 0; j < row.size() - 1; j++) {

                int curr = row.get(j);
                int next = row.get(j + 1);

                if (next > curr) {
                    if ((next - curr) >= 1 && (next - curr) <= 3)
                        increasedProperly++;
                }
                if (next < curr) {
                    if ((curr - next) >= 1 && (curr - next) <= 3)
                        decreasedProperly++;
                }
            }
            if (decreasedProperly == row.size() - 1 || increasedProperly == row.size() - 1) {
                howMuchSafe++;
            }
            if (decreasedProperly == row.size() - 2 || increasedProperly == row.size() - 2) {
                for (int j = 0; j < row.size() - 1; j++) {
                    int removed = row.remove(j);
                    int increase2 = 0;
                    int decrease2 = 0;

                    for(int i = 0; i < row.size() - 1; i++){
                        int curr = row.get(i);
                        int next = row.get(i + 1);

                        if (next > curr) {
                            if ((next - curr) >= 1 && (next - curr) <= 3)
                                increase2++;
                        }
                        if (next < curr) {
                            if ((curr - next) >= 1 && (curr - next) <= 3)
                                decrease2++;
                        }
                    }
                    if (decrease2 == row.size() - 1 || increase2 == row.size() - 1) {
                        howMuchSafe++;
                        break;
                    }
                    row.add(j, removed);
                }
            }
        }
        System.out.println(howMuchSafe);
    }

    public static void readFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                String[] tokens = line.split("\\s+");
                List<Integer> row = new ArrayList<>();
                for(String value : tokens){
                    row.add(Integer.parseInt(value));
                }
                puzzleList.add(row);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e){
            System.out.println("I/O exception");
        }
    }
}
