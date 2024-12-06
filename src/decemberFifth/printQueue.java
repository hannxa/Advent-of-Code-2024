package decemberFifth;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class printQueue {
    static List<List<Integer>> rows = new ArrayList<>();
    static List<List<Integer>> orderingRules = new ArrayList<>();

    public static void main(String[] args) {
        readFile("orderingRules.txt");
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i< rows.size(); i ++){

            for(List<Integer> orderingRule : orderingRules){
                if(rows.get(i).contains(orderingRule)){
                    int firstElement = orderingRule.get(orderingRule.size());
                    int secondElement = orderingRule.get(orderingRule.size() - 1);
                }
            }
        }

    }

    public static void readFile(String fileName){
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null ){
                String[] tokens;

                if(line.contains("|")){
                    tokens = line.split("\\|");
                    List<Integer> row1 = new ArrayList<>();
                    for(String value1 : tokens){
                        row1.add(Integer.parseInt(value1.trim()));
                    }
                    orderingRules.add(row1);

                } else if (line.contains(",")) {
                    tokens = line.split(",");
                    List<Integer> row2 = new ArrayList<>();
                    for(String value2 : tokens){
                        row2.add(Integer.parseInt(value2.trim()));
                    }
                    rows.add(row2);
                }
            }
            System.out.println(orderingRules + "|||||\n" + rows);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e){
            System.out.println("I/O exception");
        }
    }

}
