import java.lang.reflect.Array;
import java.util.Arrays;
import java.lang.System;

 
public class Solver
{
    private int noOfQueens;
    private int[] queens;
    private int noOfSolutions;

    /**
     *
     * @param noOfQueens
     */
    public void findAllSolutions(int noOfQueens)
    {
        noOfSolutions = 0;
        this.noOfQueens = noOfQueens;
        queens = new int[noOfQueens+1];

        System.out.println("*-----------------------------------*");
        System.out.println(" Solutions for "+noOfQueens+" queens:");
        System.out.println();

        long beginTime = System.currentTimeMillis();
        positionQueens(0);
        long endTime = System.currentTimeMillis();

        System.out.println();
        System.out.println(" A total of "+noOfSolutions+" solutions were found in "+(endTime-beginTime)+" ms");
        System.out.println("*-----------------------------------*");
    }

    /**
     * Du laver det her shit
     * @param row
     */
    private void positionQueens(int row) {
            if (noOfQueens == row) {
                noOfSolutions += 1;
                printSolution();
                System.out.println();
            }

            for(int col = 0; col<noOfQueens; col++) {
                if (legal(row, col)) {
                    queens[row] = col;
                    positionQueens(row+1);
                }
            }
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    private boolean legal(int row, int col) {
        int k = col+1;
        int p = col-1;
        for(int i = row-1; i>=0; i--) {
            if(Array.getInt(queens, i)==col) {
                return false;
            }
            else if(Array.getInt(queens, i)==k || Array.getInt(queens, i)==p) {
                return false;
            }
            k++;
            p--;
        }
        return true;
    }

    /**
     *
     */
    private void printSolution() {
        for (int i=0; i<queens.length; i++) {
            System.out.print(" "+convert(i, queens[i])+" ");
        }
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    private String convert(int row, int col) {
        return String.valueOf((char)('a'+row))+(col+1);
    }

    public static void main(String[] args) {
        Solver test = new Solver();
        test.findAllSolutions(6);
    }
}
