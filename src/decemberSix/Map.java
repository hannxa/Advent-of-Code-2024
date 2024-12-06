package decemberSix;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import readFile.ReadFile;

public class Map {
    static List<String> map = new ArrayList<>();

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        map = readFile.readFile("mapPuzzle.txt", map);
        char [][] tab = initializeTab();

        int endOfTableP = tab.length;
        int endOfTableM = tab.length - 1;

        char currentGuard ='^';
        int currentGuardI;
        int currentGuardJ;

        int[] guardPos = guardPosition(currentGuard);
        currentGuardI = guardPos[0];
        currentGuardJ = guardPos[1];

        char obstacle ='#';
        int nextGuardMove;
        int guardMoves = 0;

        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab.length; j++){
                if(currentGuard == '^'){
                    if((currentGuardI - 1) == endOfTableM){
                        break;
                    }else{
                        nextGuardMove = tab[currentGuardI - 1][currentGuardJ];
                        if(nextGuardMove == obstacle){
                            currentGuard = '>';
                            tab[currentGuardI][currentGuardJ] = currentGuard;
                        }else{
                            tab[currentGuardI -1][currentGuardJ] = currentGuard;
                            tab[currentGuardI][currentGuardJ] = 'X';
                            currentGuardI--;
                        }
                    }
                }
                else if(currentGuard == '>'){
                    if((currentGuardJ + 1) == endOfTableP){
                        break;
                    }else{
                        nextGuardMove = tab[currentGuardI][currentGuardJ + 1];

                        if(nextGuardMove == obstacle){
                            currentGuard = 'v';
                            tab[currentGuardI][currentGuardJ] = currentGuard;
                        }else{
                            tab[currentGuardI][currentGuardJ] = 'X';
                            tab[currentGuardI][currentGuardJ + 1] = currentGuard;
                            currentGuardJ++;
                        }
                    }
                }
                else if(currentGuard == 'v'){
                    if((currentGuardI + 1) == endOfTableP){
                        break;
                    }else{
                        nextGuardMove = tab[currentGuardI + 1][currentGuardJ];
                        if(nextGuardMove == obstacle){
                            currentGuard = '<';
                            tab[currentGuardI][currentGuardJ] = currentGuard;
                        }else{
                            tab[currentGuardI + 1][currentGuardJ] = currentGuard;
                            tab[currentGuardI][currentGuardJ] = 'X';
                            currentGuardI++;
                        }
                    }
                }
                else {
                    if((currentGuardJ - 1) == endOfTableM){
                        break;
                    }else{
                        nextGuardMove = tab[currentGuardI][currentGuardJ - 1];
                        if(nextGuardMove == obstacle){
                            currentGuard = '^';
                            tab[currentGuardI][currentGuardJ] = currentGuard;
                        }else{
                            tab[currentGuardI][currentGuardJ - 1] = currentGuard;
                            tab[currentGuardI][currentGuardJ] = 'X';
                            currentGuardJ--;
                        }
                    }
                }
            }
        }
        for (char[] chars : tab) {
            for (char aChar : chars) {
                if (aChar == 'X') {
                    guardMoves++;
                }
            }
        }
        System.out.println(guardMoves + 1);
    }

    public static int[] guardPosition(char currentGuard){
        char [][] tab = initializeTab();
        int[] currentPos = {-1,-1};

        for(int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] == currentGuard) {
                    currentPos[0] = i;
                    currentPos[1] = j;
                    return currentPos;
                }
            }
        }
        return currentPos;
    }
    public static char[][] initializeTab(){

        char [][] tab = new char [map.size()][map.size()];

        for(int i = 0; i < map.size(); i++){
            String row = map.get(i);
            for(int j = 0; j < row.length(); j++){
                tab[i][j] = row.charAt(j);
            }
        }
        return tab;
    }
}
