

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Matrix {

    public static void main(String[] args) {
        int [][] matrix = new int[42][42];
        int[][] equation = new int[1601][1601];
        generateTempMatrix(matrix);
        ArrayList<String> unknowns = generateHeadersForMatrix(matrix, equation);
        printTempMatrix(matrix);
        generateExploreObjects(equation);
        fullUnknowsForExploringWithOne(equation, unknowns);
        printMatrix44(equation);

    }
    public static void generateTempMatrix(int[][] matrix){
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                matrix[i][j] = 0;
                if (i==0 && (j!=0 && j!=(matrix[i].length-1))){
                    matrix[i][j] = 200;
                }
                if (i== matrix.length-1 && (j!=0 && j!=(matrix[i].length-1))){
                    matrix[i][j] = 150;
                }
                if (j==0 && (i!=0 && i!= matrix.length-1)){
                    matrix[i][j] = 100;
                }
                if (j==matrix[i].length-1 && (i!=0 && i!= matrix.length-1)){
                    matrix[i][j] = 50;
                }
                if ((j==matrix[i].length-1 || j ==0) && (i==0 || i== matrix.length-1)) {
                    matrix[i][j] = 8;
                }
            }
        }
    }
    public static void printTempMatrix(int [][] matrix){
        for (int i = 0; i<matrix.length; i++){
            for (int j = 0; j<matrix[i].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static ArrayList<String> generateHeadersForMatrix(int [][] matrix, int[][] equation){
        ArrayList<String> unknowns = new ArrayList<>();
        int q =0;
        int b = 1;

        for (int y = 1; y<matrix.length-1; y++){
            for (int x = 1; x<matrix[x].length-1; x++){
                if (matrix[y][x] == 0) {
                    int counter = 0;
                    unknowns.add(x + ","+y);

                    String line = x+""+y;
                    equation[0][q] = Integer.parseInt(line);
                    counter= matrix[y+1][x] + matrix[y-1][x] + matrix[y][x+1] + matrix[y][x-1];
                    equation[b][equation[b].length-1] = -counter;
                    b++;
                    q++;
                }
            }
        }
        return unknowns;
    }
//i have devided matrix into 16 parts to make it easier to create matrix in excel
    //you should call than in their order(as they are written) and full excel from left to right
    //after every 4 pastes you should go to the very left and down for 400 rows
    public static void printMatrix11 (int[][] equation){
        for (int i = 0; i<equation.length/4; i++){
            for (int j = 0; j<equation[i].length/4; j++) {

                    System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix12 (int[][] equation){
        for (int i = 0; i<equation.length/4; i++){
            for (int j = equation.length/4; j<equation[i].length/2; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix13 (int[][] equation){
        for (int i = 0; i<equation.length/4; i++){
            for (int j = equation.length/2; j<equation[i].length*3/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix14 (int[][] equation){
        for (int i = 0; i<equation.length/4; i++){
            for (int j = equation[i].length*3/4; j<equation[i].length; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix21 (int[][] equation){
        for (int i = equation.length/4; i< equation.length/2; i++){
            for (int j = 0; j<equation[i].length/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix22 (int[][] equation){
        for (int i = equation.length/4; i<equation.length/2; i++){
            for (int j = equation.length/4; j<equation[i].length/2; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix23 (int[][] equation){
        for (int i = equation.length/4; i<equation.length/2; i++){
            for (int j = equation.length/2; j<equation[i].length*3/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix24 (int[][] equation){
        for (int i = equation.length/4; i<equation.length/2; i++){
            for (int j = equation[i].length*3/4; j<equation[i].length; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix31 (int[][] equation){
        for (int i = equation.length/2; i< equation.length*3/4; i++){
            for (int j = 0; j<equation[i].length/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix32 (int[][] equation){
        for (int i = equation.length/2; i<equation.length*3/4; i++){
            for (int j = equation.length/4; j<equation[i].length/2; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix33 (int[][] equation){
        for (int i = equation.length/2; i<equation.length*3/4; i++){
            for (int j = equation.length/2; j<equation[i].length*3/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix34 (int[][] equation){
        for (int i = equation.length/2; i<equation.length*3/4; i++){
            for (int j = equation[i].length*3/4; j<equation[i].length; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix41 (int[][] equation){
        for (int i = equation.length*3/4; i< equation.length; i++){
            for (int j = 0; j<equation[i].length/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix42 (int[][] equation){
        for (int i = equation.length*3/4; i<equation.length; i++){
            for (int j = equation.length/4; j<equation[i].length/2; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix43 (int[][] equation){
        for (int i = equation.length*3/4; i<equation.length; i++){
            for (int j = equation.length/2; j<equation[i].length*3/4; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }
    public static void printMatrix44 (int[][] equation){
        for (int i = equation.length*3/4; i<equation.length; i++){
            for (int j = equation[i].length*3/4; j<equation[i].length; j++) {

                System.out.print(equation[i][j] + "\t");

            }
            System.out.println();
        }
    }

    public static void generateExploreObjects(int[][] equation){
        int j = 0;
        for (int i = 1; i<equation.length; i++){
                equation[i][j] = -4;
            j++;
        }
    }
    public static void fullUnknowsForExploringWithOne(int [][] equation, ArrayList<String> list){
        int a = 0;
        for (int i = 1; i<equation.length; i++){
            for (int j = 0; j<equation[i].length-1; j++)

            if (equation[i][j] == -4){

                String value = list.get(a);
                String[] parts = value.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                //for T(x+1, y)
                int xp1 = x+1;
                int yp1 = y;
                String res1 = xp1+","+yp1;
                //for T(x-1, y)
                int xp2 = x-1;
                int yp2 = y;
                String res2 = xp2 + "," + yp2;
                //for T(x, y+1)
                int xp3 = x;
                int yp3 = y+1;
                String res3 = xp3 + "," + yp3;
                //for T(x, y-1)
                int xp4 = x;
                int yp4 = y-1;
                String res4 = xp4 + "," + yp4;
                for (int b = 0; b< list.size(); b++){
                    if (res1.matches(list.get(b))){
                        equation[i][b] = 1;
                    }
                    if (res2.matches(list.get(b))){
                        equation[i][b] = 1;
                    }
                    if (res3.matches(list.get(b))){
                        equation[i][b] = 1;
                    }
                    if (res4.matches(list.get(b))){
                        equation[i][b] = 1;
                    }
                }

                a++;
            }

        }
    }
    public static void printUnknowns(ArrayList<String> list){
        for (String text: list){
            System.out.println(text);
        }
    }
}


