import java.lang.System;

 
public class Solver
{
    private int noOfQueens;
    private int[] queens;
    private int noOfSolutions;
    private boolean showSolutions;
    private int time;
    private  boolean showResult = true;

    /**
     * Finder antal løsninger på dronningeproblemet med noOfQueens dronninger.
     * @param noOfQueens Antal dronninger, der skal være på skakbrættet.
     */
    public void findAllSolutions(int noOfQueens)
    {
        noOfSolutions = 0;
        this.noOfQueens = noOfQueens;
        queens = new int[noOfQueens];

        if (showResult) {
            System.out.println("*-----------------------------------*");
            System.out.println(" Solutions for " + noOfQueens + " queens:");
            System.out.println();
        }

        long beginTime = System.currentTimeMillis();
        positionQueens(0);
        long endTime = System.currentTimeMillis();
        time = (int) (endTime-beginTime);

        if (showResult) {
            System.out.println();
            System.out.println(" A total of " + noOfSolutions + " solutions were found in " + (endTime - beginTime) + " ms");
            System.out.println("*-----------------------------------*");
        }
    }

    /**
     * Gennemgår alle mulige positioner for dronninger.
     * @param row Række på skakbrættet
     */
    private void positionQueens(int row) {
            if (noOfQueens == row) {
                noOfSolutions++;
                if (showResult) {
                    printSolution();
                    System.out.println();
                }
            }

            for(int col = 0; col<noOfQueens; col++) {
                if (legal(row, col)) {
                    queens[row] = col;
                    positionQueens(row+1);
                }
            }
    }

    /**
     * Tjekker om dronningen kan indsættes på den givne position.
     * @param row Række på skakbrættet
     * @param col Kolonne på skakbrættet
     * @return True (hvis dronningen kan indsættes)
     *         False(hvis dronningen ikke kan indsættes)
     */
    private boolean legal(int row, int col) {
        for(int i = 0; i<row; i++) {
            if(queens[i]==col || queens[i]-col==row-i || col-queens[i]==row-i) {
                return false;
            }
        }
        return true;
    }

    /**
     * Printer løsningerne ud på terminalen.
     */
    private void printSolution() {
        for (int i=0; i<queens.length; i++) {
            System.out.print(" "+convert(i, queens[i])+" ");
        }
    }

    /**
     * Finder antal løsninger for hver dronningerproblem fra min til max.
     * @param min Mindste dronningeproblem der skal løses.
     * @param max Største dronningeproblem der skal løses.
     */
    private void findNoOfSolutions(int min, int max) {
        System.out.println("*------------------------*");
        System.out.println("Queens          Solutions     Time(ms)    Solutions/ms");
        showResult = false;
        for(int i = min; i<=max; i++) {
            findAllSolutions(i);
            System.out.format("   %3d %,12d    %,8d       %,8d %n", noOfQueens, noOfSolutions, (time+1), noOfSolutions/(time+1));
        }
        showResult = true;
        System.out.println("*------------------------*");
    }

    /**
     * @param row Række på skakbrættet.
     * @param col Kolonne på skakbrættet.
     * @return returnerer en string, som giver række og kolonne værdier
     *  som på et skakbræt.
     */
    private String convert(int row, int col) {
        return String.valueOf((char)('a'+col))+(row+1);
    }

    /**
     * Testmetode til Solver
     */
    public static void main(String[] args) {
        Solver test = new Solver();
        test.findAllSolutions(6);
        test.findNoOfSolutions(1,12);
    }
}
