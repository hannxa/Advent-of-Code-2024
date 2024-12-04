package decemberThird;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mull {
    static List <String> separatedTokens = new ArrayList<>();

    public static void main(String[] args) {

        String targetPattern = "mul\\(\\d+,\\d+\\)";

        readFile("MullItOver.txt" , targetPattern);

        String toMultiplyPattern = "\\d+";
        Pattern pattern2 = Pattern.compile(toMultiplyPattern);
        Matcher matcher2;


        long multiplier;
        long sumator = 0;
        for(String match : separatedTokens){
            matcher2 = pattern2.matcher(match);
            int number1 = 0;
            int number2 = 0;
            if(matcher2.find()){
                String firstElement = matcher2.group();

                number1 = Integer.parseInt(firstElement);
            }
            if(matcher2.find()){
                String secondElement = matcher2.group();
                number2 = Integer.parseInt(secondElement);
            }
            multiplier = (long) number1 * number2;
            sumator += multiplier;
        }

        System.out.println(sumator);

    }
    public static void readFile(String fileName, String targetPattern) {
        Pattern pattern = Pattern.compile(targetPattern);
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                Matcher matcher = pattern.matcher(line);
                while(matcher.find()){
                    separatedTokens.add(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch(IOException e){
            System.out.println("I/O exception");
        }
    }
}
