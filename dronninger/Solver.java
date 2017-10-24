import java.lang.reflect.Array;
import java.util.Arrays;


 
public class Solver
{
    private int noOfQueens;
    private int[] queens;
    private int noOfSolutions;
    
    public void findAllSolutions(int noOfQueens)
    {
        this.noOfQueens = noOfQueens;
        queens = new int[noOfQueens+1];
        positionQueens(0);
        System.out.println(noOfSolutions);
        
    }
    
    private void positionQueens(int row) {
            for(int col = 0; col<noOfQueens; col++) {
                if(noOfQueens==row) {
                    noOfSolutions += 1;
                    Array.setInt(queens, row, 0);
                    return;
                }
                else if(legal(row,col)) {
                    Array.setInt(queens, row, col);
                    positionQueens(row+1);
                }
            }
    }
    
    private boolean legal(int row, int col) {
        int k = col+1;
        int p = col-1;
        for(int i = row-1; i>=0; i--) {
            if(Array.getInt(queens, i)==col) {
                return false;
            }
            else if(Array.getInt(queens, i)==k) {
                return false;
            }
            else if(Array.getInt(queens, i)==p) {
                return false;
            }
            k++;
            p--;
        }
        return true;
        }
    
    private void printSolution() {
        
    }
    
    private String convert(int row, int col) {
        return "";
    }
}
