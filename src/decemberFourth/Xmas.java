package decemberFourth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Xmas {
    static List<String> xmasPuzzle = new ArrayList<>();


    public static void main(String[] args) {
        readFile("xmasPuzzle.txt");
        String targetPattern1 = "XMAS";
        String targetPattern2 = "SAMX";

        Pattern pattern1 = Pattern.compile(targetPattern1);
        Pattern pattern2 = Pattern.compile(targetPattern2);

        Matcher matcher1, matcher2;
        int foundXmas = 0;

        for (String s : xmasPuzzle) {
            matcher1 = pattern1.matcher(s);
            matcher2 = pattern2.matcher(s);
            while (matcher1.find()) {
                foundXmas++;
            }
            while (matcher2.find()) {
                foundXmas++;
            }
        }
        for(int row = 0; row < xmasPuzzle.size() - 3; row++){

            String currentRow = xmasPuzzle.get(row);
            String nextRow1 = xmasPuzzle.get(row+1);
            String nextRow2 = xmasPuzzle.get(row+2);
            String nextRow3 = xmasPuzzle.get(row+3);

            for(int cow = 0; cow<currentRow.length();cow++){
                int neededLength = cow - 2;
                int neededLength2 = cow + 3;

                if(currentRow.charAt(cow)=='S' && nextRow1.charAt(cow)=='A' && nextRow2.charAt(cow)=='M'&& nextRow3.charAt(cow)=='X'){
                    foundXmas++;
                }
                if(currentRow.charAt(cow)=='X' && nextRow1.charAt(cow)=='M' && nextRow2.charAt(cow)=='A'&& nextRow3.charAt(cow)=='S'){
                    foundXmas++;
                }

                if(neededLength2<currentRow.length()){
                    if(currentRow.charAt(cow)=='X' && nextRow1.charAt(cow+1)=='M' && nextRow2.charAt(cow+2)=='A'&& nextRow3.charAt(cow+3)=='S'){
                        foundXmas++;
                    }
                    if(currentRow.charAt(cow)=='S' && nextRow1.charAt(cow+1)=='A' && nextRow2.charAt(cow+2)=='M'&& nextRow3.charAt(cow+3)=='X'){
                        foundXmas++;
                    }

                }
                if(neededLength > 0){
                    if(currentRow.charAt(cow)=='X' && nextRow1.charAt(cow-1)=='M' && nextRow2.charAt(cow-2)=='A'&& nextRow3.charAt(cow-3)=='S'){
                        foundXmas++;
                    }
                    if(currentRow.charAt(cow)=='S' && nextRow1.charAt(cow-1)=='A' && nextRow2.charAt(cow-2)=='M'&& nextRow3.charAt(cow-3)=='X'){
                        foundXmas++;
                    }
                }
            }
        }
        System.out.println(foundXmas);
    }
    public static void readFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                xmasPuzzle.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e){
            System.out.println("I/O exception");
        }
    }
}

